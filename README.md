<a name="readme-top"></a>

<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<div align="center">
  <h3 align="center">Stackoverflow Clone</h3>

  <p align="center">
    A full-stack application to post questions and answers to them.
    <br />
    <a href="https://github.com/SavolyLali/stackoverflow-clone"><strong>Explore the repo »</strong></a>
    <br />
    <br />
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->

## About The Project

Welcome to **Stackoverflow Clone**, a full-stack application built with Java Spring Boot for the backend, Angular for the frontend and MySQL for the database. This is a Q&A site. Users can post questions and see who posted one and when it was posted. They can also see the answers to the questions and who posted them. Users can also post their own answers to the questions. The application has a user authentication system, so users can register and log in to the application.

### Built With

* [![Spring Boot][SpringBoot-url]][SpringBoot.com]
* [![Java][Java-url]][Java.org]
* [![Angular][Angular-url]][Angular.com]
* [![TypeScript][TypeScript-url]][TypeScript.org]
* [![SCSS][SCSS-url]][SCSS.org]

<!-- GETTING STARTED -->

## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

#### Docker

Before installing the project, make sure you have Docker installed on your machine.
Docker can be downloaded and installed from the official Docker website. Here are the links to download Docker for
different operating systems:

[Docker Desktop for Windows](https://docs.docker.com/desktop/install/windows-install/)

[Docker Desktop for Mac](https://docs.docker.com/desktop/install/mac-install/)

[Docker Desktop for Linux](https://docs.docker.com/desktop/install/linux-install/)

### Installation

After downloading and installing Docker, follow these steps to install and run the project:

1. Clone the repo
   ```sh
   git clone https://github.com/SavolyLali/stackoverflow-clone.git
   ```

2. Navigate to the root directory of the project(Where the docker-compose.yaml file is located)


3. Create `.env` file and add the following environment variables:

   ```
    MYSQLDB_USER=<username>
    MYSQLDB_ROOT_PASSWORD=<password>
    MYSQLDB_DATABASE=<database_name>   
   ```

4. Create and run the Docker container using:

   ```sh
    docker-compose up
    ```

5. Open your browser and navigate to [http://localhost:4200](http://localhost:4200)

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- CONTACT -->

## Contact

Lajos Daniel Savoly - [GitHub Profile](https://github.com/SavolyLali)

Project
Link: [https://github.com/SavolyLali/stackoverflow-clone](https://github.com/SavolyLali/stackoverflow-clone)


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->

[contributors-shield]: https://img.shields.io/github/contributors/SavolyLali/stackoverflow-clone.svg?style=for-the-badge

[contributors-url]: https://github.com/SavolyLali/stackoverflow-clone/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/SavolyLali/stackoverflow-clone.svg?style=for-the-badge

[forks-url]: https://github.com/SavolyLali/stackoverflow-clone/network/members

[stars-shield]: https://img.shields.io/github/stars/SavolyLali/stackoverflow-clone.svg?style=for-the-badge

[stars-url]: https://github.com/SavolyLali/stackoverflow-clone/stargazers

[issues-shield]: https://img.shields.io/github/issues/SavolyLali/stackoverflow-clone.svg?style=for-the-badge

[issues-url]: https://github.com/SavolyLali/stackoverflow-clone/issues

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555

[linkedin-url]: https://www.linkedin.com/in/lajos-daniel-savoly/

[SpringBoot-url]: https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white

[SpringBoot.com]: https://spring.io/projects/spring-boot

[Java-url]: https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white

[Java.org]: https://www.java.com/

[Angular-url]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white

[Angular.com]: https://angular.io/

[TypeScript-url]: https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white

[TypeScript.org]: https://www.typescriptlang.org/

[SCSS-url]: https://img.shields.io/badge/SCSS-CC6699?style=for-the-badge&logo=sass&logoColor=white

[SCSS.org]: https://sass-lang.com/