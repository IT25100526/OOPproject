@REM Maven Wrapper for Windows
@SET MAVEN_PROJECTBASEDIR=%~dp0
@SET WRAPPER_JAR=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.jar

@IF NOT EXIST "%WRAPPER_JAR%" (
    @SET DOWNLOAD_URL=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar
    powershell -Command "Invoke-WebRequest -Uri '%DOWNLOAD_URL%' -OutFile '%WRAPPER_JAR%'"
)

@java -jar "%WRAPPER_JAR%" %*
