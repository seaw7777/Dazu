# Dazu

![Dazu%205255c23c85d344619c00cb51f60242fa/Untitled.png](Dazu%205255c23c85d344619c00cb51f60242fa/Untitled.png)

### 팀 이름

사대일은 못말려!👨‍👩‍👧‍👧

### 팀 구성원 소개

정예림 : 팀장

김지은 : 팀원

조현철 : 팀원

조희은 : 팀원

### 개인 별 업무 분장 계획

정예림 : 개발 일정 관리, Front-end 개발

김지은 : Front-end 개발

조현철 : Back-end 개발, DB 관리

조희은 : Back-end 개발

### 서비스 1줄 요약

주변 맛집의 인기 메뉴가 우리 집으로! 동네 음식점과 연결된 온라인 쿠킹 클래스

### 프로젝트 명

1. 다쥬, DAZU (Multiplex Kitchen) - 다양한 주방

### 프로젝트 기획 배경

COVID-19의 빠른 확산과 잦은 방역수칙 변경으로 소상공인들이 어려움에 처하였다.

이에 대한 대책으로 **쿠킹 클래스를 개설하여 소상공인들의 현재 재정적인 부담및 심적 부담을 덜어줄 필요성이 대두**되고 있다.

집콕 생활이 길어지면 밀키트의 수요가 증가하고 있다. 밀키트를 구입하면 쉽게 요리를 할 수 있지만 한정된 메뉴에 고민이 되었다. "온라인 쿠킹클래스와 밀키트를 접목한다면 간편한 요리에 재미를 더 할 수 있지 않을까??"라는 생각을 가지게 되었다.

![Dazu%205255c23c85d344619c00cb51f60242fa/Untitled%201.png](Dazu%205255c23c85d344619c00cb51f60242fa/Untitled%201.png)

![Dazu%205255c23c85d344619c00cb51f60242fa/Untitled%202.png](Dazu%205255c23c85d344619c00cb51f60242fa/Untitled%202.png)

### 화면 정의서(링크로 대체)

[화면정의서](https://www.notion.so/80b7e8725f9b43219aa8793b042a95bb)

## Project Structure

```bash
📦PJT
 ┣ 📂Backend		#Backend
 ┃ ┣ 📂src/main/java	#Backend 코드
 ┃  ┣ 📂Controller
 ┃  ┣ 📂Mapper
 ┃  ┣ 📂Model
 ┃  ┣ 📂Service
 ┣ 📂Frontend		# FrontEnd
 ┃ ┣ 📂vue-front 
 ┃ 	┣ 📂src				# Front 코드
 ┣ 📂참고자료		# 산출물
 ┃ ┣ 📂pjt01_DB				# DB 관련
 ┃ ┣ 📂pjt-1_wireframe		# 와이어프래임
 ┗ 📜README.md			# 프로젝트 README
```

## 실행

#### Frontend 실행

- 위치로 이동후 실행

```bash
$ cd frontend
$ npm install
$ npm run serve
```

- [http://localhost:8080/](http://localhost:8080/) 에서 확인 가능

#### Backend 실행

- 위치로 이동후 실행

```bash
$ cd backend
#window에서 실행 시
$ .\mvnw spring-boot:run
```

- [http://localhost:8000/swagger-ui.html](http://localhost:8000/swagger-ui.html%EC%9D%84)을 통해 swagger 확인 가능

### 프로젝트 상세 소개

- 지역별 쿠킹클래스
    - 설정한 거주지 주변 음식점과 연계하여 화상 쿠킹클래스를 열어준다. 손님이 상대적으로 덜 북적이는 시간에 화상 쿠킹클래스를 열면 추가 매출를 얻을 수 있다.
    - 상호작용을 통해 요리감이 부족한 사용자는 요리감 과 정보를 얻을 수 있다. 강사와 게시글을 통해 연락할 수 있다.
    - 추가적으로 지역뿐 아니라 '전국 맛집 기획전'을 열어 전국 맛집 쿠킹클래스 개최도 가능하다.
- 지역별 음식 관련 커뮤니티
    - 자신만의 맛있는 요리 팁 & 맛집을 공유하는 커뮤니티이다. 주변 사람들과 자신만의 레세피를 공유하고 소통함으로써 실생활의 밀접함을 느낄 수 있다.
- 밀키트 판매 (우리의 수익모델)
    - 쿠킹클래스의 특징으로는 해당 수업의 재료를 제공해주는 것이다. 온라인으로 진행되는 쿠킹 클래스인 만큼 재료 제공 부분이 약화된다. 이를 극복하기 위해 쿠킹 클래스에 해당하는 밀키트를 제공한다,
    - 밀키트 제공에는 3가지의 경우가 있다. (수업만, 수업 + 밀키트, 밀키트만) 집에 재료가 많은 사람은 메뉴 상세 설명에 있는 재료를 알아서 준비 할 수 있고, 밀키트만 사고 싶은 사람은 해당 가게 메뉴의 밀키트를 구입 할 수 있다.
    - 만약, 해당 수업과 밀키트를 같이 구입한 손님에게 약간의 할일을 제공한다.
    - 기존의 밀키트와 달리 레세피 주인과 직접 상호작용하며 만들 수 있다는 또 다른 특징이 있다.

## 🖥️Tech Stacks

## Tech Stack

![Spring](https://img.shields.io/badge/Vue-2.6.12-green?style=flat&logo=Vue.js) ![Vuetify](https://img.shields.io/badge/Vuetify-2.0.9-green?style=flat&logo=Vuetify)![Vue](https://img.shields.io/badge/Spring-2.42-success?style=flat&logo=Spring)![Prettier](https://img.shields.io/badge/Prettier-%5E6.0.0-yellow?style=flat&logo=Prettier)![ESlint](https://img.shields.io/badge/ESlint-4.5.0-yellow?style=flat&logo=ESlint)

![MYSQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white)![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=Docker&logoColor=white)![Jenkins](https://img.shields.io/badge/Jenkins-D24939?style=flat-square&logo=Jenkins&logoColor=white)

## ✏️ GitHub

[seaw7777/Dazu](https://github.com/seaw7777/Dazu)

## 👩🏻‍🔧 My Parts

### 백엔드

- 스프링을 이용한 파일 업로드 구현
- 가게 사장님 상세페이지 구현
- 화상회의 개설시 링크 제공 구현
- 데이터베이스 설계
- 회원 수강 신청여부 확인 기능 구현
- 강의 목록 및 밀키트 쇼핑몰 판매 목록 CRUD
- SQL 쿼리 작성
- 각종 게시판 CRUD작성

### 프론트엔드

- 파일 업로드 구현

## 배포

- EC2 서버에 Docker를 이용하여 배포 진행
- Jenkins를 docker-compose를 이용하여 구동
- Jenkins webhook을 이용하여 Git commit 시 자동 배포 진행
- 프론트엔드와 백엔드 Dockerfile을 통하여 배포 설정 저장 및 Jenkinsfile을 이용한 자동화
- Nginx를 사용하여 HA와 Load Balancing 및 Reverse Proxy 설정
- https 적용을 위해 SSL 키 사용하여 보안 향상

## 😟 TroubleShooting

### 배포를 위한 설정 파일에서 패스 설정 문제

 배포를 혼자 담당하게 되었고 배포를 진행해본 적이 없다 보니 새로 공부하여야 했습니다. 이 프로젝트가 삼성 청년 SW 아카데미 2학기 과정의 공통 프로젝트로써 진행되었기에 코치에게 배포에 대한 기본 자료를 받아 진행하였습니다. 하지만 명령어가 어떤 역할을 하는지 몰랐고 이미지 이름이나 Dockerfile의 위치를 어디에 적어야 하는지 정확히 몰라 많이 헤매게 되었습니다.

 이를 해결하기 위하여 먼저 Docker의 기본부터 공부하였습니다. 기존 가상머신을 활용하는 것과 Docker를 사용하는 것의 차이점을 먼저 이해한 후 Jenkinsfile과 Dockerfile에 어떤 내용이 적히는 것인지를 공부하였습니다. 이를 통해 Jenkinsfile에 build와 run을 하는 stage를 나누었고, 자동 배포 시에 기존에 돌아가고 있던 컨테이너를 멈추고 지운 후 다시 실행하는 방법을 이용하여 배포를 진행할 수 있었습니다.

### 수익 모델 (or 상용 서비스로써의 가치) 분석

- 광고
- 쿠킹클래스 연계 수수료
- 스토어 - 밀키트 판매