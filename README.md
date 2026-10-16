# Gestion de Recursos Humanos

Sistema de recursos humanos para crear y actualizar trabajadores de tres tipos y generar reportes por departamento.

## Detalle

| | |
|---|---|
| Tipo | Consola (MVC) |
| Archivos Java | 9 |
| Version de Java | 25 |
| Patron | Arquitectura MVC con jerarquia de clases e interfaz comun |

## Funcionalidades

- Trabajadores contratista, de tiempo completo y de ventas
- Reportes de distribucion por area
- Reportes por departamento
- Busqueda por cedula
- Interfaz IEmpleado

## Estructura del proyecto

```
empresaDesarollo2_Dia06-03-2026/
|-- pom.xml       configuracion de Maven, importable desde cualquier IDE
|-- src/          codigo fuente
`-- README.md
```

## Como ejecutarlo

### Con Maven

```bash
mvn clean compile
mvn exec:java
```

### Con javac directamente

```bash
# Linux / macOS
javac -d bin $(find src -name "*.java")

# Windows (PowerShell)
javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName
```

```bash
java -cp bin co.edu.unbosque.controller.AplMain
```

### Desde un IDE

Cualquier IDE con soporte de Java (Eclipse, IntelliJ IDEA, VS Code o NetBeans)
puede importar el proyecto directamente como **proyecto Maven**. Basta con abrir
o importar la carpeta: el IDE detecta el `pom.xml`, resuelve las dependencias y
compila sin configuracion adicional.

## Autor

Desarrollado por [Sergio Parra](https://github.com/P2X4A) como parte de su
formacion en Java.

## Licencia

Ver el archivo [LICENSE](LICENSE).