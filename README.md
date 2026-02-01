# 🦁 Darija Translator Pro - Extension Chrome AI

**Darija Translator Pro** est une solution complète (Full-stack) qui permet de transformer n'importe quel texte web en **Darija Marocaine** authentique. L'application utilise la puissance des LLM (Large Language Models) pour offrir une traduction qui respecte le contexte culturel marocain.

---

## 📺 Démonstration Vidéo
Ne manquez pas la présentation complète du projet, incluant la démo technique et l'explication du code :

👉 **[Regarder la Vidéo de Présentation (Google Drive)](https://drive.google.com/file/d/17wcM8CZ4B9S5Ut9t2k3gdawW6ZnkimNR/view?usp=sharing)**

---

## 🛠️ Architecture du Projet

Le projet est divisé en deux parties principales :

### 1. Frontend (Extension Chrome)
- **Manifest V3** : Utilisation des dernières normes Google pour les extensions.
- **Side Panel UI** : Une interface moderne en *Glassmorphism* (Peach & Mint).
- **Auto-fill Feature** : Un `content.js` qui détecte la sélection de texte et l'envoie automatiquement à l'extension.
- **Asynchronous Communication** : Utilisation de `fetch` pour communiquer avec le Backend.

### 2. Backend (Spring Boot / JAX-RS)
- **`TranslatorResource.java`** : API REST qui reçoit les textes à traduire.
- **`GeminiService.java`** : Le cœur de l'IA. Il communique avec l'API **Groq (Llama 3.3-70b)** avec un *System Prompt* optimisé pour la Darija (Alphabet arabe).
- **`CorsFilter.java`** : Gestion de la sécurité pour autoriser les requêtes provenant de l'extension.

---

## 🧠 Logic de Traduction (Prompt Engineering)
Le modèle est configuré pour :
- ✅ Utiliser exclusivement l'alphabet arabe.
- ✅ Employer des termes purement marocains (`ديال`, `بزاف`, `شنو`...).
- ✅ Éviter l'Arabe Classique (Fusha) et le langage SMS (Latin).



---

## 🚀 Installation & Utilisation

### Backend
1. Importer le projet dans **Eclipse** ou IntelliJ.
2. S'assurer que les dépendances (OkHttp, Gson, JAX-RS) sont installées via Maven.
3. Lancer l'application sur le port `8080`.

### Frontend
1. Ouvrir Chrome et aller sur `chrome://extensions/`.
2. Activer le **Mode Développeur**.
3. Cliquer sur **Charger l'extension dépaquetée** et sélectionner le dossier du Frontend.

---

## 📌 Roadmap
- [x] Traduction de texte (Français/Anglais -> Darija).
- [x] Détection automatique de la sélection.
- [ ] **Mode Image (OCR)** : Traduction directe à partir d'images (Coming Soon).
- [ ] Historique des traductions locales.

---
## Developped by:
*BOUJOUDAR Amal - Étudiante en master WISD*
