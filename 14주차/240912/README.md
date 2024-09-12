## 목차 [미니 프로젝트]
- [사용자별 역할 지정](#사용자별-역할-지정)
  - [관리자](#관리자)
  - [관리자, 회원](#관리자-회원)
  - [비회원](#비회원)
- [entity](#entity)
  - [User](#user)
  - [Product](#product)
- [url 설정](#url-설정)
  - [회원가입 \[POST\]](#회원가입-post)
  - [로그인 \[POST\]](#로그인-post)
  - [토큰 재발급 \[POST\]](#토큰-재발급-post)
  - [이메일 중복 체크 \[GET\]](#이메일-중복-체크-get)
  - [(추가) 닉네임 중복 체크 \[GET\]](#추가-닉네임-중복-체크-get)
  - [상품 등록 \[POST\]](#상품-등록-post)
  - [상품 수정 \[PATCH\]](#상품-수정-patch)
  - [상품 삭제 \[DELETE\]](#상품-삭제-delete)
  - [상품 전체 조회 \[GET\]](#상품-전체-조회-get)
  - [상품 조회 \[GET\]](#상품-조회-get)

<br/>
<br/>
<br/>
<br/>

# 사용자별 역할 지정
## 관리자
- 상품 등록
## 관리자, 회원 
- 상품 전체 조회
- 상품 조회
## 비회원 
- 회원가입
- 로그인

<br/>
<br/>
<br/>
<br/>

# entity
## User
- id
- email (unique)
- name
- password
- role (USER / ADMIN)
- createdAt
- updatedAt

## Product
- id
- name
- price
- createdAt
- updatedAt

<br/>
<br/>
<br/>
<br/>

# url 설정
## 회원가입 [POST]
- `/api/auth/signin`
```
[Reqest] {name, email, password}
[Response] 201 or 400
```
## 로그인 [POST]
- `/api/auth/login`
```
[Request] {email, password}
[Response] 200 {accessToken} (+refresh token 저장) or 401
```
## 토큰 재발급 [POST]
 - `/api/auth/refresh-token`
```
[Response] 200 {accessToken} or 401
```
## 이메일 중복 체크 [GET] 
- `/api/auth/email-check`
```
[requestParam] {email}
[Response] 200 (boolean true or false) or 409
```
## (추가) 닉네임 중복 체크 [GET] 
- `/api/auth/name-check` 
```
[reqestParam] {name}
[Response] 200 (boolean true or false) or 409
```
## 상품 등록 [POST] 
- `/api/product/add` 
```
[Request] {name, price}
[Response] 201 {id, name, price} or 401 or 403
```
## 상품 수정 [PATCH] 
- `/api/product/update` 
```
[Request] {id, name, price}
[Response] 200 {id, name, price} or 401 or 403
```
## 상품 삭제 [DELETE]
- `/api/product/delete/{id}` 
```
[requestParm] {id}
[Response] 200 {id, name, price} or 401 or 403
```

## 상품 전체 조회 [GET] 
- `/api/product/productlist` 
```
[Response] 200 List<id, name, price> or 401
```
## 상품 조회 [GET] 
-  `/api/product/{id}` 
```
[pathVariable] {id}
[Response] 200 {id, name, price} or 401
```