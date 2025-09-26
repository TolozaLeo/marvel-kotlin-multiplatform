# 🚀 Marvel KMM App

![Kotlin](https://img.shields.io/badge/Kotlin-2.0.0-blueviolet?logo=kotlin)
![KMM](https://img.shields.io/badge/KMM-Multiplatform-orange)
![Ktor](https://img.shields.io/badge/Ktor-Client-lightblue?logo=ktor)
![SQLDelight](https://img.shields.io/badge/SQLDelight-Cache-yellow)
![MVVM](https://img.shields.io/badge/Android-MVVM-green)
![Hexagonal](https://img.shields.io/badge/Arquitectura-Hexagonal-red)
![Koin](https://img.shields.io/badge/DI-Koin-purple)

Aplicación multiplataforma desarrollada en **Kotlin Multiplatform Mobile (KMM)** que consume la **API pública de Marvel** para mostrar un listado de personajes.  
El proyecto fue realizado como un **primer acercamiento al ecosistema KMM**, explorando su potencial para compartir lógica entre plataformas.  
La UI de IOS no pudo desarrollada por falta de hardware adecuado (MAC OS).

---

## 📱 Funcionalidades
- Consulta de personajes desde la API pública de Marvel.  
- Listado simple y claro de personajes.  
- Manejo de caché local con **SQLDelight** para funcionamiento de cache offline.  
- Arquitectura **Hexagonal** con **MVVM** en la capa de Android.  

---

## 🛠️ Tecnologías utilizadas
- **Kotlin Multiplatform Mobile (KMM)**  
- **Ktor Client** (para consumo de la API)  
- **Kotlin Serialization** (para parseo de JSON)  
- **SQLDelight** (para base de datos local y caché)  
- **MVVM** en Android  
- **Arquitectura Hexagonal** en el módulo compartido
- **Koin** (inyección de dependencias)  

---

## 📂 Estructura del proyecto
```bash
.
├── androidApp/          # App Android nativa (UI con MVVM + DI)
├── iosApp/              # Placeholder para iOS
├── shared/              # 
│   ├── cache/           # Base de datos SQLDeLight
│   ├── commonMain/      # Lógica compartida para Android e IOS
│   │   ├── data/            # Acceso a datos (API, caché, repositorios)
│   │   ├── domain/          # Casos de uso y modelos del dominio
```

## ⚙️ Instalación y configuración (Android)
1. Clonar el repositorio:  
   ```bash
   git clone https://github.com/TolozaLeo/marvel-kotlin-multiplatform.git
   ```
2. Crear una cuenta en [Marvel Developer](https://developer.marvel.com/) y obtener tus API Keys.
3. En el archivo local.properties agregar:
   ```bash
   MARVEL_PUBLIC_KEY=tu_public_key
   MARVEL_PRIVATE_KEY=tu_private_key
   ```
4. Abrir el proyecto en Android Studio.
5. Ejecutar la app en un dispositivo o emulador Android.
