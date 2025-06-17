INPUT="./infrastructure/dependencies.txt"
OUTPUT="dependencies-download-links.txt"

> $OUTPUT

while IFS=: read -r groupId artifactId packaging version scope
do
  if [[ "$groupId" != "" && "$artifactId" != "" && "$version" != "" ]]; then
    groupPath=$(echo $groupId | tr '.' '/')
    baseUrl="https://repo.maven.apache.org/maven2/${groupPath}/${artifactId}/${version}"
    jarUrl="${baseUrl}/${artifactId}-${version}.${packaging}"
    pomUrl="${baseUrl}/${artifactId}-${version}.pom"

    echo $jarUrl >> $OUTPUT
    echo $pomUrl >> $OUTPUT
  fi
done < <(grep ':' $INPUT)

echo "Links gerados em $OUTPUT"