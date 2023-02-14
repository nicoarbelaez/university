<div align='center'>
  <img src="https://i.imgur.com/gCrmgVQ.png" height="100">
  <h1>APO2-2023 | Guía para trabajar con Git en GitHub en Windows</h1>
  <sup>Deja tu ⭐ si te ayudo en algo.</sup>
</div>

---


## Índice

- [¿Que es Git?](#que-es-git)
- [Requisitos](#requisitos)
- [Cómo ver si una carpeta tiene Git](#cómo-ver-si-una-carpeta-tiene-git)
  - [Activar la visualización de elementos ocultos](#activar-la-visualización-de-elementos-ocultos)
  - [Ver la carpeta ".git"](#ver-la-carpeta-git)
- [Cómo ingresar a la terminal directamente desde una carpeta](#cómo-ingresar-a-la-terminal-directamente-desde-una-carpeta)
  - [Utilizar la ruta de la carpeta y el comando cmd](#utilizar-la-ruta-de-la-carpeta-y-el-comando-cmd)
  - [Dar clic derecho y elegir "Git Bash Here"](#dar-clic-derecho-y-elegir-git-bash-here)
- [Comenzar a usar Git](#comenzar-a-usar-git)
  - [Clonar un repositorio](#clonar-un-repositorio)
  - [Verificar el estado de tus archivos](#verificar-el-estado-de-tus-archivos)
  - [Agregar archivos al repositorio](#agregar-archivos-al-repositorio)
  - [Realizar un commit](#realizar-un-commit)
  - [Enviar cambios al repositorio en línea](#enviar-cambios-al-repositorio-en-línea)
- [Subir archivos a un repositorio sin clonarlo](#subir-archivos-a-un-repositorio-sin-clonarlo)

## ¿Que es Git?
Git es un sistema de control de versiones que permite a los desarrolladores guardar y controlar los cambios en su proyecto. Con Git, puedes colaborar con otros desarrolladores, revertir cambios, crear ramas para desarrollar funcionalidades separadas y mucho más.
Recomendación para visualizar carpetas con Git

**[⬆️ Volver a índice](#índice)**

## Requisitos 
Para utilizar Git con GitHub, hay algunos requisitos previos que debes cumplir:

1. Instalar Git en tu computadora:
Git es un software de control de versiones distribuido. Antes de poder utilizar Git con GitHub, debes tener Git instalado en tu computadora. Puedes descargar la última versión de Git desde el sitio web oficial en [https://git-scm.com/downloads](https://git-scm.com/downloads).

2. Crear una cuenta en GitHub:
GitHub es una plataforma en línea que permite alojar y colaborar en proyectos de software. Para poder utilizar Git con GitHub, debes crear una cuenta en GitHub. La creación de una cuenta es gratuita y puedes hacerlo en [https://github.com/](https://github.com/).

3. Configurar Git en tu computadora:
Una vez que tengas Git instalado en tu computadora, debes configurar Git con tu información personal. Ejecuta los siguientes comandos en la línea de comandos o terminal:
```bash
$ git config --global user.name "Tu nombre"
$ git config --global user.email "tu_correo_electronico@ejemplo.com"
```

4. Crear un repositorio en GitHub:
Para crear un repositorio en GitHub, debes iniciar sesión en tu cuenta de GitHub y hacer clic en el botón ["New repository"](https://github.com/new). Luego, debes ingresar un nombre para el repositorio y una descripción opcional. Puedes elegir hacer público o privado el repositorio y decidir si quieres agregar un archivo README inicial.

Con estos requisitos cumplidos, estás listo para utilizar Git con GitHub.

**[⬆️ Volver a índice](#índice)**

## Cómo ver si una carpeta tiene Git

Si deseas ver si una carpeta en tu sistema tiene un repositorio Git, hay una forma fácil de hacerlo activando la visualización de elementos ocultos.

### Activar la visualización de elementos ocultos
1. Abre File Explorer y navega hasta la carpeta que deseas verificar.
1. Haz clic en el botón "Ver" o "Vista" en la barra de herramientas.
1. Haz clic en "Mostrar" (Windows 11).
1. Busca la opción "Elementos ocultos" y marca la opción.

**Windows 11**

<img src="https://i.imgur.com/mdmhcfb.jpg" width="250">

**Windows 10**

<img src="https://i.imgur.com/fqs1fBO.jpg" height="100">

### Ver la carpeta ".git"
Después de activar la visualización de elementos ocultos, deberías ser capaz de ver una carpeta llamada ".git" en la carpeta que deseas verificar. Esta carpeta contiene todos los archivos y configuraciones necesarios para el repositorio Git.

Si ves la carpeta ".git", significa que la carpeta que estás viendo es un repositorio Git. Si no ves la carpeta ".git", significa que la carpeta no es un repositorio Git.

**[⬆️ Volver a índice](#índice)**

## Cómo ingresar a la terminal directamente desde una carpeta
Hay varias formas principales. Explicaremos dos de esas formas de ingresar a una terminal directamente desde una carpeta en Windows: utilizar la ruta de la carpeta y usar el comando cmd, o dar clic derecho y elegir "Git Bash Here".

### Utilizar la ruta de la carpeta y el comando cmd
1. Abre File Explorer y navega hasta la carpeta desde la cual quieres ingresar a la terminal.
1. Haz clic en la barra de direcciones para seleccionar la ruta completa de la carpeta.
1. Escribe "cmd" en la barra de direcciones y presiona Enter.
1. Se abrirá una terminal en la ruta de la carpeta que seleccionaste.
### Dar clic derecho y elegir "Git Bash Here"
1. Abre File Explorer y navega hasta la carpeta desde la cual quieres ingresar a la terminal.
1. Haz clic derecho en la carpeta.
1. Elegir "Git Bash Here" en el menú desplegable.
1. Se abrirá una terminal en la ruta de la carpeta que seleccionaste.

Es importante mencionar que esta opción solo estará disponible si tienes Git instalado en tu sistema.

Con estos dos métodos, puedes ingresar a la terminal directamente desde cualquier carpeta en Windows y empezar a trabajar en la línea de comandos.

**[⬆️ Volver a índice](#índice)**

## Comenzar a usar Git

### Clonar un repositorio
Primero debemos conseguir la URL de un repositorio de GitHub, siga estos sencillos pasos:

1.  Abre GitHub y accede al repositorio que deseas clonar.
1.  Haz clic en el botón azul "Clone or download".
1.  Haz clic en el botón "Copy to clipboard" para copiar la URL del repositorio.

<img src="https://i.imgur.com/fBjIZEa.png" width="400">

Ahora puedes utilizar esta URL en el comando git clone para clonar el repositorio en tu computadora.

---

Para clonar un repositorio de GitHub, debes abrir la [terminal](#cómo-ingresar-a-la-terminal-directamente-desde-una-carpeta). Luego, escribe el siguiente comando y presiona Enter:

```bash
$ git clone [url del repositorio]
```

Por ejemplo, si quieres clonar este repositorio, debes escribir:

```bash
$ git clone https://github.com/nicoarbelaez/APO2-2023.git
```

<img src="https://i.imgur.com/M3JAp7q.png" width="400">

### Verificar el estado de tus archivos

Debes ingresar a la carperta del repositorio , con el siguiente comando o ver [Cómo ingresar a la terminal directamente desde una carpeta](#cómo-ingresar-a-la-terminal-directamente-desde-una-carpeta):

```bash
$ cd [nombre del repositorio]
```

Antes de realizar cambios en tu repositorio local, es recomendable verificar el estado de tus archivos. Para hacer esto, escribe el siguiente comando en la terminal:

```bash
$ git status
```

<img src="https://i.imgur.com/PDslJb8.png" width="400">

### Agregar archivos al repositorio

Después de realizar cambios en tus archivos, debes agregarlos al repositorio local para poder hacer un commit. Para agregar todos los archivos modificados, escribe el siguiente comando en la terminal:

```bash
$ git add .
```

<img src="https://i.imgur.com/JyDpEI6.png" width="400">

Si realizas de nuevo `git status` deberia salir el **modified** en verde.

### Realizar un commit

Después de agregar los archivos, debes realizar un commit para guardar los cambios en el repositorio local. Para hacer un commit, escribe el siguiente comando en la terminal:

```bash
$ git commit -m "Mensaje de commit"
```

Reemplaza Mensaje de commit con un mensaje que describa los cambios que has realizado.

<img src="https://i.imgur.com/n7QLWyA.png" width="400">

Si realizas de nuevo `git status` no deberia aparecer ningun archivo.

### Enviar cambios al repositorio en línea

Finalmente, debes enviar los cambios del repositorio local al repositorio en línea de GitHub. Para hacer esto, escribe el siguiente comando en la terminal:

```bash
$ git push
```

<img src="https://i.imgur.com/zBUl3gs.png" width="600">

Cuando hayas registrado tus credenciales, el commit se habrá subido al repositorio en línea.

<img src="https://i.imgur.com/ogq9iWw.png" width="400">

Podrás ver tu commit reflejado en los archivos que subiste en el repositorio, de esta forma.

<img src="https://i.imgur.com/qYDVezN.png" width="600">

**[⬆️ Volver a índice](#índice)**

## Subir archivos a un repositorio sin clonarlo

1. Asegúrate de estar dentro de la carpeta del repositorio.
1. Coloca todos los archivos y/o modifica los archivos existentes en la carpeta.
1. Verifica el estado de tus archivos con el comando `git status`.
1. Agrega los archivos modificados con el comando `git add .`.
1. Realiza un commit con el comando `git commit -m "Mensaje de commit"`
1. Finalmente, envía los cambios al repositorio en línea de GitHub con el comando `git push`.

**[⬆️ Volver a índice](#índice)**

**Espero que esta guía te haya ayudado a entender cómo utilizar Git. ¡Buena suerte con tus proyectos de Git!**
