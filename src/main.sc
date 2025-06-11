require: slotfilling/slotFilling.sc
  module = sys.zb-common

theme: /
    state: Приветствие
        q!: $regex</start>
        intent!: /привет
        a: Здравствуйте! Какой у вас вопрос?

    state: Помощь
        q!: Мне нужна помощь
        a: Да, я вас внимательно слушаю и готов помочь. Какой у вас вопрос?

    state: Помощь2
        q!: Вы можете мне помочь
        a: Конечно, я готов вам помочь. Какой у вас вопрос?
        
    state: Fallback
        event!: noMatch
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
              type: 'switch',
              messageToUser: 'Хорошо, передаю ваш вопрос своим коллегам'
            });
