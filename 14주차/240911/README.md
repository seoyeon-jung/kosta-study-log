## 목차
- [JWT Access Token, Refresh Token 흐름 정리](#jwt-access-token-refresh-token-흐름-정리)
- [React-cookie 사용해서 acessToken cookie로 이동](#react-cookie-사용해서-acesstoken-cookie로-이동)
  - [react-cookie 설치](#react-cookie-설치)
  - [`cookieUtils` 파일 생성](#cookieutils-파일-생성)
  - [cookie로 변경](#cookie로-변경)
- [Access Token, Refresh Token 동작](#access-token-refresh-token-동작)
- [접근 경로 지정하기 \[프론트\]](#접근-경로-지정하기-프론트)
  - [`AccessControl.jsx` 파일 생성](#accesscontroljsx-파일-생성)
  - [Router 부분 수정](#router-부분-수정)

<br/>
<br/>
<br/>
<br/>

# JWT Access Token, Refresh Token 흐름 정리
[JWT에서 Access Token, Refresh Token이 필요한 이유](https://daydream-sy.tistory.com/338) 블로그 글

<br/>
<br/>
<br/>
<br/>

# React-cookie 사용해서 acessToken cookie로 이동
## react-cookie 설치
```
yarn add react-cookie
```
## `cookieUtils` 파일 생성
```javascript
import { Cookies } from "react-cookie";

const cookies = new Cookies();

export const setCookie = (name, value, options) => {
  return cookies.set(name, value, { ...options });
};

export const getCookie = (name) => {
  return cookies.get(name);
};

export const removeCookie = (name) => {
  return cookies.remove(name);
};
```
## cookie로 변경
- `useProvider.jsx`
```javascript
const useProvideAuth = () => {
  const [userInfo, setuserInfo] = useState(null);

  const login = async (data, successCallBack = null) => {
    try {
      const res = await userAPI.login(data);

      if (res.status === 200) {
        const token = res.data.accessToken;
        setCookie("accessToken", token, { path: "/" });

        const jwtPayload = jwtDecode(token);
        setuserInfo({
          id: jwtPayload.id,
          email: jwtPayload.sub,
          role: jwtPayload.role,
        });
        if (successCallBack) successCallBack();
      }
    } catch (error) {
      console.error(error);
    }
  };

  const logout = (callBack = null) => {
    removeCookie("accessToken");
    setuserInfo(null);
    if (callBack) callBack();
  };

  const tokenCheck = () => {
    const token = getCookie("accessToken");
    if (token) {
      const jwtPayload = jwtDecode(token);
      if (jwtPayload.exp > Date.now() / 1000) {
        return true;
      }
    }
    return false;
  };

  return { userInfo, login, logout, tokenCheck };
};
```
- `api.js`
```javascript
api.interceptors.request.use(
  (config) => {
    const token = getCookie("accessToken");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    } else {
      delete config.headers.Authorization;
    }
    return config;
  },
  (err) => {
    return Promise.reject(err);
  }
);

// 응답할 때 사용하는 interceptor
// response에 따라서 분기가 가능하다
api.interceptors.response.use(
  (res) => {
    // response가 있는 경우 response의 data 반환
    return res;
  },
  async (err) => {
    const originReq = err.config;
    if (err.response.status === 403 && !originReq._retry) {
      originReq._retry = true; // 플래그 설정

      // 만약에 권한이 없다는 에러가 나오면 토큰 재발급 해주도록 할 것이다.
      try {
        // token 재발급
        const response = await refreshTokenHandler();

        // 정상 재발급 시
        if (response.status === 200) {
          // token값 쿠키에 저장
          setCookie("accessToken", response.data.accessToken);
          // header에 새로운 token 추가하기
          originReq.headers.Authorization = `Bearer ${response.data.accessToken}`;

          // 실패했던 요청 다시 보내기
          return api.request(originReq);
        }
      } catch (error) {
        console.err("토큰 재발급 실패");
        // error 처리
        return Promise.reject(err);
      }
    }
    return Promise.reject(err);
  }
);
```

<br/>
<br/>
<br/>
<br/>

# Access Token, Refresh Token 동작
|ACCESS TOKEN|REFRESH TOKEN||
|---|---|---|
|유효|유효|모든 요청에 대해서 권한만 있다면 정상적 동작|
|무효|유효|`403`이 발생하고 재발급이 요청되어서 모든 요청에 대해서 권한만 있다면 정상적 동작|
|유효|무효|모든 요청에 대해서 권한만 있다면 정상적 동작|
|무효|무효|`403` 발생하고 재발급 요청 후 `401` 발생 로그아웃 처리 후 로그인 화면으로 이동|

<br/>
<br/>
<br/>
<br/>

# 접근 경로 지정하기 [프론트]
## `AccessControl.jsx` 파일 생성
```javascript
// 접근 제어용 컴포넌트
const AccessControl = ({ children, roleList }) => {
  const { userInfo } = useAuth();
  const role = userInfo?.role || "none";

  if (roleList.includes(role)) {
    return children;
  } else {
    return <>권한 없음</>;
  }
};

export default AccessControl;
```
## Router 부분 수정
```javascript
<Route path="/favorite" element={
    <AccessControl roleList={["ROLE_USER", "ROLE_ADMIN"]}>
        <Favorite />
    </AccessControl>}
/>
```
=> 이런 식으로 AccessControl로 감싸주어 role을 지정해주었다