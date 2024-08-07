# 뉴스 웹 서비스 만들기 실습

## 이미지 불러오기
- 이미지는 별도의 스토리지에 저장하는 것이 좋다
- 프로젝트 내에 폴더를 만들어서 저장하는 것은 별로 좋지 않음

외부 경로 설정
- Server 폴더의 server.xml 파일에 외부 경로 추가
- `<Context docBase="C:\\Users\\WD" path="/img" reloadable="true" />`