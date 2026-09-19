# Sistema de Classificação (App de Avaliação com RatingBar)

Aplicativo Android desenvolvido na **Aula 6 – Construindo aplicações no Android**
(disciplina de **Desenvolvimento Mobile**). O app permite avaliar um jogo
(Angry Birds) usando o componente **RatingBar** e exibe o *status* da nota.

## 🎯 Objetivo da entrega

A partir do app original de classificação, a atividade pediu duas melhorias:

1. **Acrescentar mais uma estrela** → agora são **5 estrelas** no total.
2. **Tratar o problema da meia estrela** → uma meia estrela **não** deve
   promover a avaliação para a categoria seguinte.
   - Exemplo: **4 estrelas e meia** deve exibir **"Excelente"** (e **não**
     "Espetacular").
   - Apenas **5 estrelas cheias** resultam em **"Espetacular"**.

## ⭐ Regra de classificação

| Nota (rating) | Status               |
|:-------------:|----------------------|
| 0,5           | Selecione uma nota   |
| 1,0 – 1,5     | Regular              |
| 2,0 – 2,5     | Bom                  |
| 3,0 – 3,5     | Ótimo                |
| 4,0 – 4,5     | Excelente            |
| 5,0           | Espetacular          |

A lógica utiliza o "piso" de cada estrela cheia (`>= 1.0`, `>= 2.0`, ...),
garantindo que a meia estrela nunca suba de categoria.

## 🛠️ Tecnologias

- **Linguagem:** Java
- **IDE:** Android Studio
- **Build:** Gradle (Kotlin DSL) + AGP 9.3.1
- **compileSdk/targetSdk:** 37 · **minSdk:** 24
- **Componentes:** `RatingBar`, `ImageView`, `TextView`, `RelativeLayout`

## 📂 Estrutura principal

```
app/src/main/
├── java/com/example/classificacao/MainActivity.java   # Lógica do status
├── res/layout/activity_main.xml                        # Tela (5 estrelas)
├── res/values/strings.xml                              # Textos
├── res/values/colors.xml                               # Cores
├── res/values/themes.xml                               # Tema
└── res/drawable/jogo_angry_birds.webp                  # Imagem do jogo
```

## ▶️ Como executar

1. Abra o projeto no **Android Studio**.
2. Aguarde o *Gradle Sync* baixar as dependências.
3. Selecione um emulador ou dispositivo físico.
4. Clique em **Run ▶**.
5. Ajuste as estrelas e observe o **Status** atualizar em tempo real.

## 👤 Autor

Matheus Carvalho — Desenvolvimento Mobile / Projeção.
