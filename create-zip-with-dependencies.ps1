$source = "$env:USERPROFILE\.m2\repository"
$destination = ".\m2-poms.zip"

# Remove o ZIP se já existir
if (Test-Path $destination) { Remove-Item $destination }

# Pega todos os arquivos .pom e .bom
$files = Get-ChildItem -Path $source -Recurse -Include *.pom,*.bom

# Cria um diretório temporário para manter a estrutura
$tempDir = Join-Path $env:TEMP "m2-poms-temp"
if (Test-Path $tempDir) { Remove-Item -Recurse -Force $tempDir }
New-Item -ItemType Directory -Path $tempDir | Out-Null

foreach ($file in $files) {
    # Caminho relativo ao repositório
    $relativePath = $file.FullName.Substring($source.Length + 1)

    # Caminho no diretório temporário
    $targetPath = Join-Path $tempDir $relativePath

    # Cria o diretório se não existir
    $targetDir = Split-Path $targetPath
    if (!(Test-Path $targetDir)) {
        New-Item -ItemType Directory -Path $targetDir -Force | Out-Null
    }

    # Copia o arquivo
    Copy-Item -Path $file.FullName -Destination $targetPath
}

# Agora compacta tudo preservando a estrutura
Compress-Archive -Path "$tempDir\*" -DestinationPath $destination

Write-Output "ZIP gerado em: $destination"

# (Opcional) Remove o temporário
Remove-Item -Recurse -Force $tempDir