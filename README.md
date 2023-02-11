# APO2-2023 | Guía para trabajar con Git en GitHub
Git es un sistema de control de versiones que permite a los desarrolladores guardar y controlar los cambios en su proyecto. Con Git, puedes colaborar con otros desarrolladores, revertir cambios, crear ramas para desarrollar funcionalidades separadas y mucho más.

## Clonar un repositorio
Para clonar un repositorio de GitHub, debes abrir la terminal (en Windows 10, presiona Win + X y selecciona Windows PowerShell). Luego, escribe el siguiente comando y presiona Enter:

```cmd
git clone [url del repositorio]
```

>Para conseguir la URL de un repositorio de GitHub, siga estos sencillos pasos:
>
>1. Abre GitHub y accede al repositorio que deseas clonar.
>1. Haz clic en el botón verde "Clone or download".
>1. Haz clic en el botón "Copy to clipboard" para copiar la URL del repositorio.
>
><img src="https://i.imgur.com/fBjIZEa.png" width="400">
>
>Ahora puedes utilizar esta URL en el comando git clone para clonar el repositorio en tu computadora.

Por ejemplo, si quieres clonar este repositorio, debes escribir:

```
git clone https://github.com/nicoarbelaez/APO2-2023.git
```
<img src="https://i.imgur.com/M3JAp7q.png" width="400">

### Verificar el estado de tus archivos
Debes ingresar a la carperta del repositorio, con el siguiente comando:
```
cd [nombre del repositorio]
```

Antes de realizar cambios en tu repositorio local, es recomendable verificar el estado de tus archivos. Para hacer esto, escribe el siguiente comando en la terminal:

```
git status
```
<img src="https://i.imgur.com/PDslJb8.png" width="400">

### Agregar archivos al repositorio
Después de realizar cambios en tus archivos, debes agregarlos al repositorio local para poder hacer un commit. Para agregar todos los archivos modificados, escribe el siguiente comando en la terminal:

```
git add .
```
<img src="https://i.imgur.com/JyDpEI6.png" width="400">

_Si realizas de nuevo `git status` deberia salir el **modified** en verde._

### Realizar un commit
Después de agregar los archivos, debes realizar un commit para guardar los cambios en el repositorio local. Para hacer un commit, escribe el siguiente comando en la terminal:

```
git commit -m "Mensaje de commit"
```
Reemplaza Mensaje de commit con un mensaje que describa los cambios que has realizado.

<img src="https://i.imgur.com/n7QLWyA.png" width="400">

_Si realizas de nuevo `git status` no deberia aparecer ningun archivo._

### Enviar cambios al repositorio en línea
Finalmente, debes enviar los cambios del repositorio local al repositorio en línea de GitHub. Para hacer esto, escribe el siguiente comando en la terminal:

```
git push
```

<img src="https://i.imgur.com/zBUl3gs.png" width="600">

Cuando hayas registrado tus credenciales, el commit se habrá subido al repositorio en línea.

<img src="https://i.imgur.com/ogq9iWw.png" width="400">

#### Podrás ver tu commit reflejado en los archivos que subiste en el repositorio, de esta forma.
<img src="https://i.imgur.com/qYDVezN.png" width="600">

## Subir archivos a un repositorio sin clonarlo

1. Asegúrate de estar dentro de la carpeta del repositorio.
1. Coloca todos los archivos y/o modifica los archivos existentes en la carpeta.
1. Verifica el estado de tus archivos con el comando `git status`.
1. Agrega los archivos modificados con el comando `git add .`.
1. Realiza un commit con el comando `git commit -m "Mensaje de commit"`
1. Finalmente, envía los cambios al repositorio en línea de GitHub con el comando `git push`.

[Pasos a seguir](#verificar-el-estado-de-tus-archivos)

###### Espero que esta guía te haya ayudado a entender cómo utilizar Git. ¡Buena suerte con tus proyectos de Git!
