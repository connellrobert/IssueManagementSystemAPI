# Issue Management System API
## Description
The Issue Management System API is meant to perform as a standalone api as well as a service in a cluster. This particular service is to track projects within a company and their issues. 

## Running the application
### Build and run the container
1. `docker build -t some_name .`
2. 
 - `docker run -e DATASOURCE_URL=<jdbc url> -e DATASOURCE_USERNAME=<jdbc username> -e DATASOURCE_PASSWORD=<jdbc password> -e SERVER_PORT=<server port> -p <some port>:<server port> some_name`
 - Insert the environment variables in the dockerfile prior to the build process and run: `docker run -p <some port>:<server port> some_name`


Ensure the following environment variables are set in the container while running:
- DATASOURCE_URL = The jdbc url for the database
- DATASOURCE_USERNAME = The username for the database you are using
- DATASOURCE_PASSWORD = The password for the database you are using
- SERVER_PORT = The port for the application to run on inside the container

## WIP
- [X] Multiple DB Engine support
- [X] Containerization with multi stage builds
- [ ] Testing
- [ ] Generate API docs using spring test docs