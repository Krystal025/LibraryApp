# Project

<b>학습용 Toy Project "도서관리 웹 애플리케이션"</b>
- 프로젝트 일정 : 2024/06/12 ~ 2024/06/26
- 프로젝트 개발인원 : BackEnd 1명 
- 프로젝트 도메인 : http://www.studying-developer.site:8080/v1/index.html
- 프로젝트 GitHub : https://github.com/Krystal025/LibraryApp
</br>

## 프로젝트 개요
---
### 목적
- 등록된 사용자가 도서를 대출하고 반납할 수 있는 서비스를 제공
- 실제 배포를 통한 클라우드 및 AWS 개념 학습

### 주요 기능
- 사용자 등록
- 사용자 정보 수정, 삭제, 조회
- 도서 등록
- 사용자의 도서 대출 및 반납
</br>

## 기술 스택
---
### BackEnd
<div style="display : flex">
    <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"/>
    <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
    <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"/>
    <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white">
    <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"/>
    <img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white"/> 
</div>
<br/>

### Tools
<div style="display : flex">
    <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white"/> 
    <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=gitHub&logoColor=white"/> 
    <img src="https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black"> 
    <img src="https://img.shields.io/badge/Amazon%20EC2-FF9900?style=for-the-badge&logo=Amazon%20EC2&logoColor=white">
    <img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"/>
</div>
</br>

### Java 17
- 주 프로그래밍 언어로 Java 17을 선택하였습니다.
- Spring Boot 3.0 이후 Java 17 이상 버전만 호환 가능하고, 현재 가장 많이 migrate 하는 버전이기 때문입니다.

### Spring Boot
- 백엔드 개발 프레임워크로 Spring Boot를 사용하였습니다. 
- Spring Boot의 다양한 스타터 패키지와 내장된 서버가 작은 규모의 개인 프로젝트에 유용하다고 판단하였습니다.

### MySQL
- 데이터베이스로는 MySQL을 선택하였습니다.
- 현업에서 많이 사용되기도 하고, 이전에 Oracle 및 MariaDB를 사용해보았기 때문에 학습용으로 선택하게 되었습니다.

### JPA
- 작은 규모의 데이터를 다루는 프로그램이고, Spring Boot에서 권장하기 때문에 학습용으로 선택하게 되었습니다. 
- SQL 쿼리문을 직접 작성하지 않아 실수가 줄고, 특정 DB에 종속적이지 않아 유지보수도 용이하기 때문입니다. 

### Gradle
- 빌드 도구로는 Gradle을 사용하였습니다. 
- Gradle은 빠른 빌드 속도와 유연한 설정이 가능하여 이 프로젝트에 적합하다고 판단하였습니다.

### Git, GitHub
- 소스코드 버전관리는 Git을 사용하였고, 유지보수는 GitHub을 사용하였습니다. 
- 버전관리 전략으로는 Git Flow를 이용하여 진행하였습니다.
</br>

## Git Branch 관리 전략
---
- Main : 배포시 사용합니다.
- Develop : 테스트 완료된 기능을 Merge하여 실제 동작을 테스트합니다.
- Feature : 기능개발시 사용합니다.
</br>

## 테스트
---
- Postman을 통해 단위 테스트를 진행하였습니다.
- IP주소와 port 번호를 통한 API를 이용하여 통합 테스트를 진행하였습니다.
- 배포후 도메인을 이용하여 최종 애플리케이션 테스트를 진행하였습니다. 
</br>




