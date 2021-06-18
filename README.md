# Issue Management System API
## Description
The Issue Management System API is meant to perform as a standalone api as well as a service in a cluster. This particular service is to track projects within a company and their issues. 
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