#!/usr/bin/env sh
set -e

WRAPPER_DIR="$(dirname "$0")/.mvn/wrapper"
WRAPPER_JAR="$WRAPPER_DIR/maven-wrapper.jar"
PROPERTIES_FILE="$WRAPPER_DIR/maven-wrapper.properties"

# read wrapperUrl from properties
WRAPPER_URL=$(grep -E '^wrapperUrl=' "$PROPERTIES_FILE" | cut -d= -f2-)

# download jar if missing
if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Downloading Maven Wrapper jar..."
  mkdir -p "$WRAPPER_DIR"
  if command -v curl >/dev/null 2>&1; then
    curl -fsSL "$WRAPPER_URL" -o "$WRAPPER_JAR"
  elif command -v wget >/dev/null 2>&1; then
    wget -q "$WRAPPER_URL" -O "$WRAPPER_JAR"
  else
    echo "Error: curl or wget required to download Maven Wrapper" >&2
    exit 1
  fi
fi

exec java ${MAVEN_OPTS} -jar "$WRAPPER_JAR" "$@"
