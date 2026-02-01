document.addEventListener('DOMContentLoaded', () => {
    const input = document.getElementById('inputText');
    const result = document.getElementById('result');
    const copyBtn = document.getElementById('copyBtn');

    // 1. Logic d'Auto-selection (Message de content.js)
    chrome.runtime.onMessage.addListener((msg) => {
        if (msg.type === "UPDATE_TEXT") {
            input.value = msg.text;
        }
    });

    
    
    document.querySelectorAll('.mode-btn').forEach(btn => {
        btn.addEventListener('click', (e) => {
            
            if (e.target.innerText.trim() === "Image") {
                alert("Coming Soon! 🚀.");
            }
        });
    });

    // 3. Clear
    document.getElementById('clearBtn').addEventListener('click', () => {
        input.value = '';
        result.innerText = 'Translation will appear here...';
        copyBtn.style.display = 'none';
    });

    // 4. Copy Result
    copyBtn.addEventListener('click', () => {
        navigator.clipboard.writeText(result.innerText);
        copyBtn.innerText = "Copied!";
        setTimeout(() => { copyBtn.innerText = "Copy"; }, 2000);
    });

    // 5. Translate 
    document.getElementById('translateBtn').addEventListener('click', async () => {
        const text = input.value.trim();
        if (!text) return;

        result.innerHTML = '<span style="color:#888; font-size:14px;">Translating... 🦁</span>';
        
        try {
            const res = await fetch('http://localhost:8080/darija-translator/api/translate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': 'Basic ' + btoa('admin:password123')
                },      
                body: JSON.stringify({ text: text })
            });
            const data = await res.json();
            if (data.translatedText) {
                result.innerText = data.translatedText;
                copyBtn.style.display = 'block'; 
            }
        } catch (e) {
            result.innerText = "Backend Error!";
        }
    });
});