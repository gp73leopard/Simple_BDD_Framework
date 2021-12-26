#language:ru
  @HelpCreateTicket
  Функция: Создание тикета с высоким приоритетом
    - Создание тикета с высоким приоритетом "2"
    - Проверка его существования
    - Удаление тикета после окончания работы с ним

    Сценарий: Создание тикета

      Когда сгенерировать переменные
        | title                  |      new_ticket_EEEDDD      |
        | submitter_email        |  new_ticket_EEEDDD@mail.ru  |
        | status                 |              1              |
        | priority               |              2              |
        | queue                  |              1              |
      И создать запрос
        | method   |        body        |                        url                           |
        | POST     |  ticket.json |  https://at-sandbox.workbench.lanit.ru/api/tickets   |
      Также добавить header
        | Content-Type | application/json |
      То отправить запрос
      А статус код 201
      Когда извлечь данные
        | id | $.id |
      То сравнить значения
        | ${id} | != | null |

    Сценарий: Проверка существования созданного тикета

      Когда создать запрос
        | method |                           url                            |
        | GET    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      И добавить header
        | accept | application/json |
      То отправить запрос
      А статус код 200
      Когда извлечь данные
        | resp_title            |      $.title      |
        | resp_submitter_email  | $.submitter_email |
        | resp_id               |       $.id        |
      То сравнить значения
        |        ${id}       | == |        ${resp_id}       |
        |      ${title}      | == |      ${resp_title}      |
        | ${submitter_email} | == | ${resp_submitter_email} |

    Сценарий: Удаление созданного тикета и его проверка на отсутствие

      Когда создать запрос
        | method |                           url                            |
        | DELETE | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      То отправить запрос
      И статус код 204
      Когда создать запрос
        | method |                           url                            |
        | GET    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      И добавить header
        | accept | application/json |
      Тогда отправить запрос
      А статус код 404