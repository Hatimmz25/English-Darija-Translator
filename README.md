# Darija Translator - Chrome Extension & RESTful Web Service

[![Chrome Extension](https://img.shields.io/badge/Chrome-Extension-blue?logo=google-chrome)](https://chrome.google.com/webstore)
[![Java](https://img.shields.io/badge/Java-JAX--RS-orange?logo=java)](https://jcp.org/en/jsr/detail?id=370)

**Darija Translator Pro** is a full-stack web service solution that transforms English text into authentic **Moroccan Darija** using the power of Large Language Models (LLMs). This academic project demonstrates the implementation of a RESTful web service with a modern Chrome extension interface.

> 📚 **Academic Project** - Web Services Course  
> 👨‍🏫 **Instructor**: Pr. El Habib Nfaoui  
> 👩‍🎓 **Developer**: Mazigh Hatim - Master WISD Student

---

## 📺 Project Demonstration

Watch the complete project presentation, including technical demo and code walkthrough:

👉 **[Watch Full Presentation (Google Drive)]()**


---

## 🎯 Project Overview

This project fulfills the requirements of the Web Services course by implementing:

✅ **RESTful Web Service** using JAX-RS API  
✅ **LLM Integration** with Groq (Llama 3.3-70b) for intelligent translation  
✅ **Chrome Extension** (Manifest V3) with Side Panel API  
✅ **PHP Client Application** for web integration  
✅ **Security Implementation** using Jakarta Authentication (Basic Auth)  
✅ **Multiple Testing Methods** (Postman, SoapUI, cURL)

The service translates English text to Moroccan Darija (الدارجة المغربية) while preserving cultural context and authenticity.

---

## ✨ Features

### Core Features
- 🌐 **Real-time Translation**: English → Moroccan Darija
- 🎨 **Modern UI**: Glassmorphism design (Peach & Mint theme)
- 📝 **Auto-fill**: Automatic text selection detection
- 🔒 **Secure API**: Basic authentication implementation
- 📱 **Side Panel Integration**: Seamless Chrome browsing experience

### Translation Intelligence
- ✅ Exclusive use of Arabic alphabet (الحروف العربية)
- ✅ Authentic Moroccan expressions (`ديال`, `بزاف`, `شنو`, etc.)
- ✅ Avoids Classical Arabic (Fusha) and SMS language
- ✅ Context-aware translation using advanced prompt engineering

---

## 🏗️ Architecture

The project follows a **client-server architecture** with three main components:

```
┌─────────────────────────────────────────────────────────────┐
│                     Chrome Extension                        │
│  ┌──────────────┐  ┌──────────────┐  ┌──────────────┐      │
│  │  Side Panel  │  │  Content.js  │  │  Background  │      │
│  │  (UI Layer)  │  │  (Detector)  │  │   Script     │      │
│  └──────┬───────┘  └──────┬───────┘  └──────┬───────┘      │
│         │                 │                 │               │
│         └─────────────────┴─────────────────┘               │
│                           │                                 │
│                           │ HTTPS/REST API                  │
│                           ▼                                 │
│         ┌─────────────────────────────────────┐             │
│         │      RESTful Web Service (Backend)  │             │
│         │  ┌──────────────────────────────┐   │             │
│         │  │  TranslatorResource.java     │   │             │
│         │  │  (JAX-RS Endpoint)           │   │             │
│         │  └──────────┬───────────────────┘   │             │
│         │             │                       │             │
│         │  ┌──────────▼───────────────────┐   │             │
│         │  │  GeminiService.java          │   │             │
│         │  │  (LLM Integration)           │   │             │
│         │  └──────────┬───────────────────┘   │             │
│         │             │                       │             │
│         │  ┌──────────▼───────────────────┐   │             │
│         │  │  CorsFilter.java             │   │             │
│         │  │  (Security & CORS)           │   │             │
│         │  └──────────────────────────────┘   │             │
│         └─────────────────────────────────────┘             │
│                           │                                 │
│                           │ API Call                        │
│                           ▼                                 │
│         ┌─────────────────────────────────────┐             │
│         │     Groq API (Llama 3.3-70b)        │             │
│         │     Large Language Model            │             │
│         └─────────────────────────────────────┘             │
└─────────────────────────────────────────────────────────────┘
```

### Component Breakdown

#### 1. **Frontend - Chrome Extension** (Manifest V3)
- **Side Panel UI**: Modern glassmorphism interface
- **Content Script**: Detects text selection and triggers translation
- **Background Script**: Manages extension lifecycle and API communication
- **Asynchronous Communication**: Uses `fetch` API for backend requests

#### 2. **Backend - Spring Boot Application**
- **`TranslatorResource.java`**: JAX-RS REST endpoint (`/translate`)
- **`GeminiService.java`**: LLM service layer with optimized Darija prompt
- **`CorsFilter.java`**: Cross-Origin Resource Sharing configuration
- **Authentication Filter**: Jakarta Authentication for API security

#### 3. **LLM Integration**
- **Provider**: Groq API
- **Model**: Llama 3.3-70b-versatile
- **Prompt Engineering**: Custom system prompt for Darija translation

---

## 💻 Technologies Used

### Backend
- **Java 17+**
- **JAX-RS API** (RESTful Web Services)
- **Spring Boot** (Application Framework)
- **OkHttp** (HTTP Client)
- **Gson** (JSON Processing)
- **Jakarta Authentication** (Security)
- **Maven** (Dependency Management)

### Frontend
- **Chrome Extension API** (Manifest V3)
- **JavaScript (ES6+)**
- **HTML5 / CSS3**
- **Side Panel API**

### AI/ML
- **Groq API** (LLM Provider)
- **Llama 3.3-70b** (Language Model)

### Testing
- **Postman** (API Testing)
- **SoapUI** (SOAP/REST Testing)
- **cURL** (Command-line Testing)

---

## 📥 Installation Guide

### Prerequisites

- **Java Development Kit (JDK) 17+**
- **Maven 3.6+**
- **Google Chrome Browser**
- **Groq API Key** ([Get one here](https://console.groq.com))
- **IDE**: Eclipse, IntelliJ IDEA, or VS Code

### Backend Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Hatimmz25/English-Darija-Translator.git
   cd English-Darija-Translator/backend
   ```

2. **Configure API Key**
   
   Create `src/main/resources/application.properties`:
   ```properties
   groq.api.key=YOUR_GROQ_API_KEY_HERE
   server.port=8080
   ```

3. **Install dependencies**
   ```bash
   mvn clean install
   ```

4. **Run the application**
   ```bash
   mvn spring-boot:run
   ```
   
   The server will start on `http://localhost:8080`

5. **Verify installation**
   ```bash
   curl http://localhost:8080/api/translate/test
   ```

### Chrome Extension Setup

1. **Navigate to extension directory**
   ```bash
   cd ../frontend/chrome-extension
   ```

2. **Update API endpoint** (if needed)
   
   Edit `sidepanel.js` or `config.js`:
   ```javascript
   const API_URL = 'http://localhost:8080/api/translate';
   ```

3. **Load extension in Chrome**
   - Open Chrome and navigate to `chrome://extensions/`
   - Enable **Developer mode** (top-right toggle)
   - Click **Load unpacked**
   - Select the `chrome-extension` folder

4. **Pin the extension**
   - Click the puzzle icon in Chrome toolbar
   - Pin "Darija Translator"

### PHP Client Setup

1. **Navigate to PHP client directory**
   ```bash
   cd ../php-client
   ```

2. **Configure endpoint**
   
   Edit `config.php`:
   ```php
   <?php
   define('API_URL', 'http://localhost:8080/api/translate');
   define('API_USERNAME', 'admin');
   define('API_PASSWORD', 'password');
   ?>
   ```

3. **Start PHP server**
   ```bash
   php -S localhost:8000
   ```

4. **Access the client**
   
   Open `http://localhost:8000` in your browser

---

## 📡 API Documentation

### Base URL
```
http://localhost:8080/api
```

### Endpoints

#### 1. Translate Text

**POST** `/translate`

Translates English text to Moroccan Darija.

**Request Headers:**
```http
Content-Type: application/json
Authorization: Basic YWRtaW46cGFzc3dvcmQ=
```

**Request Body:**
```json
{
  "text": "Hello, how are you?"
}
```

**Response:**
```json
{
  "original": "Hello, how are you?",
  "translation": "السلام، كيداير؟",
  "language": "darija",
  "timestamp": "2026-02-01T10:30:00Z"
}
```

**Status Codes:**
- `200 OK`: Translation successful
- `400 Bad Request`: Invalid input
- `401 Unauthorized`: Authentication failed
- `500 Internal Server Error`: Translation service error

#### 2. Health Check

**GET** `/translate/health`

Checks if the service is running.

**Response:**
```json
{
  "status": "UP",
  "service": "Darija Translator",
  "timestamp": "2026-02-01T10:30:00Z"
}
```

---

## 🧪 Testing

### 1. Postman Testing

1. **Import Collection**
   - Import `tests/postman/DarijaTranslator.postman_collection.json`
   
2. **Set Environment Variables**
   - `base_url`: `http://localhost:8080/api`
   - `username`: `admin`
   - `password`: `password`

3. **Run Tests**
   - Execute the "Translate Text" request
   - Check response time and status

### 2. SoapUI Testing

1. **Create REST Project**
   - File → New REST Project
   - Enter: `http://localhost:8080/api`

2. **Add Test Case**
   - Right-click on endpoint → New Request
   - Method: POST
   - Endpoint: `/translate`
   - Add Basic Auth header

3. **Execute and Validate**

### 3. cURL Testing

```bash
# Test translation endpoint
curl -X POST http://localhost:8080/api/translate \
  -H "Content-Type: application/json" \
  -H "Authorization: Basic YWRtaW46cGFzc3dvcmQ=" \
  -d '{"text":"Good morning"}'

# Test health endpoint
curl -X GET http://localhost:8080/api/translate/health

# Test with different text
curl -X POST http://localhost:8080/api/translate \
  -u admin:password \
  -H "Content-Type: application/json" \
  -d '{"text":"I love learning new languages"}'
```

---

## 🔒 Security

### Authentication Implementation

The service uses **Jakarta Authentication** with **Basic Authentication**:

```java
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authHeader = requestContext.getHeaderString("Authorization");
        
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Missing or invalid Authorization header")
                    .build()
            );
            return;
        }
        
        // Validate credentials
        String[] credentials = decodeBasicAuth(authHeader);
        if (!isValidUser(credentials[0], credentials[1])) {
            requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid credentials")
                    .build()
            );
        }
    }
}
```

### CORS Configuration

Cross-Origin Resource Sharing is configured to allow extension requests:

```java
@Provider
public class CorsFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext request, 
                       ContainerResponseContext response) {
        response.getHeaders().add("Access-Control-Allow-Origin", 
            "chrome-extension://YOUR_EXTENSION_ID");
        response.getHeaders().add("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS");
        response.getHeaders().add("Access-Control-Allow-Headers", 
            "Content-Type, Authorization");
    }
}
```

### Security Best Practices

- ✅ Never commit API keys to version control
- ✅ Use environment variables for sensitive data
- ✅ Implement rate limiting for API endpoints
- ✅ Validate and sanitize all user inputs
- ✅ Use HTTPS in production

---

## 🧠 Prompt Engineering

The translation quality relies on a carefully crafted system prompt:

```
You are an expert translator specializing in Moroccan Darija (الدارجة المغربية).

CRITICAL RULES:
1. Use ONLY Arabic script (الحروف العربية) - NO Latin letters
2. Use authentic Moroccan expressions:
   - ديال (of/for)
   - بزاف (a lot/very)
   - شنو (what)
   - واش (is it/question marker)
   - كيفاش (how)
3. AVOID:
   - Classical Arabic (Fusha)
   - SMS language or Arabizi
   - Egyptian or other dialects
4. Maintain natural Moroccan conversational tone
5. Preserve cultural context

Translate the following text to Darija:
```

---

## 🗺️ Roadmap

### Completed ✅
- [x] JAX-RS RESTful Web Service
- [x] Chrome Extension (Manifest V3)
- [x] LLM Integration (Groq/Llama)
- [x] PHP Client Application
- [x] Basic Authentication
- [x] Postman/SoapUI/cURL Testing
- [x] Auto-fill text detection
- [x] Side Panel UI

### In Progress 🚧
- [ ] **Speech Translation** (Voice-to-Voice)
- [ ] **Text-to-Speech** (Read Aloud Feature)
- [ ] **OCR Integration** (Image Translation)

### Planned 📅
- [ ] **Local LLM Deployment** (Lightweight model)
- [ ] **Embedded Container** (Jetty/Tomcat)
- [ ] **Translation History** (Local storage)
- [ ] **Offline Mode** (Cached translations)
- [ ] **Multi-language Support** (French, Spanish → Darija)
- [ ] **Browser Extension** (Firefox, Edge support)
- [ ] **Mobile App** (Android/iOS)

---

## 📁 Project Structure

```
darija-translator-pro/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/translator/
│   │   │   │       ├── resource/
│   │   │   │       │   └── TranslatorResource.java
│   │   │   │       ├── service/
│   │   │   │       │   └── GeminiService.java
│   │   │   │       ├── filter/
│   │   │   │       │   ├── CorsFilter.java
│   │   │   │       │   └── AuthenticationFilter.java
│   │   │   │       └── model/
│   │   │   │           └── TranslationRequest.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   └── pom.xml
│
├── frontend/
│   ├── chrome-extension/
│   │   ├── manifest.json
│   │   ├── sidepanel.html
│   │   ├── sidepanel.js
│   │   ├── content.js
│   │   ├── background.js
│   │   └── styles/
│   │       └── sidepanel.css
│   └── php-client/
│       ├── index.php
│       ├── config.php
│       └── styles.css
│
├── tests/
│   ├── postman/
│   │   └── DarijaTranslator.postman_collection.json
│   └── curl/
│       └── test-commands.sh
│
├── docs/
│   ├── API_DOCUMENTATION.md
│   ├── DEPLOYMENT_GUIDE.md
│   └── USER_MANUAL.md
│
├── README.md
└── LICENSE
```

---




---

## 🙏 Acknowledgments

- **Pr. El Habib Nfaoui** - Course Instructor
- **Groq** - For providing free LLM API access
- **Anthropic/Google** - For LLM technology inspiration
- **Chrome Extensions Team** - For excellent documentation



---

## ⭐ Star History

If you find this project useful, please consider giving it a star! ⭐

---

<div align="center">

**Made with ❤️ for the Moroccan Arabic Community**

🇲🇦 **الدارجة المغربية** 🇲🇦

</div>
