# Swapi
> Prueba técnica para Desarrollador Android

## 🎥 Demo

<p align="center">
  <a href="previews/screenrecord.mp4">
    <img src="/previews/screenshot.png" width="75%" alt="Demo de la app"/>
  </a>
</p>
<p align="center">
  <em>Haz clic en la imagen para ver la demo en video (MP4)</em>
</p>


## Descripción
Swapi es una aplicación desarrollada en Kotlin para Android que permite consumir datos de la API pública de SWAPI (“Star Wars API”) para mostrar información relacionada con el universo de Star Wars.  
El propósito de este proyecto es demostrar habilidades en arquitectura Android, consumo de API, manejo de datos, UI/UX y buenas prácticas de desarrollo móvil.

## Tecnologías utilizadas
- Kotlin
- Android SDK
- Jetpack (ViewModel, LiveData/StateFlow, etc)
- Retrofit para consumo de API
- Coroutines para asincronía
- Arquitectura MVVM 
- Gradle (Kotlin DSL)
- Dagger Hilt 
- Navigation Component
- Mockk (para test)
- ccp (libreria para codigos de numeros de paises)

## Instalación / Inicio rápido
1. Clona el repositorio:
   ```bash
   git clone https://github.com/srodevs/Swapi.git
2. Abre el proyecto en Android Studio.
3. Configura un dispositivo emulador o físico Android (versión mínima según el minSdkVersion).
4. Ejecuta la aplicación.

## Funcionalidades

- Listado de personajes / planetas (según lo que consuma la API). 
- Detalle de cada elemento seleccionado. 
- Manejo de estados: carga, éxito, error. 
- UI limpia y responsiva. 
- Arquitectura modular o bien estructurada que permita escalabilidad. 
- Buenas prácticas: manejo de errores, conexiones de red, separación de responsabilidades.

## Estructura del proyecto

```
Swapi/
├─ app/
│  ├─ src/main/java/...
│  │   ├─ ui/        ← pantallas, adaptadores
│  │   ├─ data/      ← modelos, fuentes de datos (API, DB)
│  │   ├─ domain/    ← casos de uso (opcional)
│  │   ├─ di/        ← inyección de dependencias (opcional)
│  ├─ src/main/res/  ← layouts, drawables, etc.
├─ build.gradle.kts
├─ settings.gradle.kts
└─ README.md
```

## Api usada
Se consume la API pública de SWAPI(https://swapi.dev).
Por ejemplo:
- GET /people/ → listado de personajes 
- GET /planets/ → listado de planetas

## Buenas prácticas implementadas

- Separación de capas (UI / Data / Domain). 
- Uso de coroutines para tareas asincrónicas. 
- Manejo de errores de red y estados de carga. 
- Dependencias bien gestionadas. 
- Código legible y modular. 
- Tests unitarios de casos de uso.


---
¡Gracias por revisar este proyecto!
