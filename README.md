# 🌐 ReplyBot

![Telegram Bot](https://example.com/telegram-bot-banner.png)

## 📖 Описание проекта

**VPN Support Bot** — это Telegram-бот, предназначенный для поддержки пользователей VPN-сервисов. Бот позволяет пользователям отправлять сообщения модераторам, а модераторы могут отвечать на них через команду `/reply`.

## 🚀 Функциональные возможности

- 📩 **Получение сообщений от пользователей**: Бот принимает сообщения от пользователей и передает их модераторам.
- 👥 **Взаимодействие модераторов с пользователями**: Модераторы могут отвечать пользователям через команду `/reply`.
- 🔒 **Проверка прав модераторов**: Только пользователи с правами модератора могут использовать команду `/reply`.

## 🛠️ Структура проекта

```plaintext
├── src/
│   ├── main/
│   │   ├── java/kz/mono/
│   │   │   ├── bot/
│   │   │   │   └── SupportBot.java        # Основной класс бота
│   │   │   ├── service/
│   │   │   │   ├── impl/
│   │   │   │   │   └── ...                # Реализации сервисов
│   │   │   │   └── ...                    # Интерфейсы сервисов
│   │   │   └── utils/
│   │   │       └── JsonUtils.java         # Утилита для чтения JSON
│   └── resources/
│       └── moderators.json                # JSON файл с ID модераторов
└── README.md                              # Документация проекта
