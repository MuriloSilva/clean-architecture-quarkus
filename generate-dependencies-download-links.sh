(cd ~/.m2/repository &&
find . -type f | while read file; do
  url="https://repo.maven.apache.org/maven2/$(echo $file | sed 's#^\./##' | tr '\\' '/' )"
  echo "$url"
done) > dependencies-download-links.txt
