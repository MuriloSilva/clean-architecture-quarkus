@echo off
setlocal
set WRAPPER_DIR=%~dp0\.mvn\wrapper
set WRAPPER_JAR=%WRAPPER_DIR%\maven-wrapper.jar
set PROPERTIES_FILE=%WRAPPER_DIR%\maven-wrapper.properties
for /f "tokens=1,2 delims==" %%A in ('findstr ^wrapperUrl= "%PROPERTIES_FILE%"') do set WRAPPER_URL=%%B
if not exist "%WRAPPER_JAR%" (
  echo Downloading Maven Wrapper jar...
  if exist "%SystemRoot%\System32\curl.exe" (
    curl -fsSL %WRAPPER_URL% -o "%WRAPPER_JAR%"
  ) else if exist "%SystemRoot%\System32\wget.exe" (
    wget -q %WRAPPER_URL% -O "%WRAPPER_JAR%"
  ) else (
    powershell -Command "& {Invoke-WebRequest -Uri %WRAPPER_URL% -OutFile '%WRAPPER_JAR%'}"
  )
)
java %MAVEN_OPTS% -jar "%WRAPPER_JAR%" %*
