CREATE DATABASE IF NOT EXISTS `department_db`;
CREATE DATABASE IF NOT EXISTS `employee_db`;
CREATE DATABASE IF NOT EXISTS `organisation_db`;

GRANT ALL PRIVILEGES ON `employee_db`.* TO "microservice_temp_user"@"%";
GRANT ALL PRIVILEGES ON `organisation_db`.* TO "microservice_temp_user"@"%";
GRANT ALL PRIVILEGES ON `department_db`.* TO "microservice_temp_user"@"%";