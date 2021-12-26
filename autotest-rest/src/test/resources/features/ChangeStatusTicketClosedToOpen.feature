#language:ru
  @HelpDeskChangeStatus
  Функция: Создание тикета
    - Создание тикета с закрытым статусом "4"
    - Проверка его существования
    - Попытка изменения статуса на открытый "1"
    - Удаление тикета после окончания работы с ним

    Сценарий: Создание тикета с закрытым статусом

      Когда сгенерировать переменные
        | title                  |      new_ticket_EEEDDD      |
        | submitter_email        |  new_ticket_EEEDDD@mail.ru  |
        | status                 |              4              |
        | priority               |              3              |
        | queue                  |              1              |
      И создать запрос
        | method   |        body        |                        url                           |
        | POST     |  ticket.json       |  https://at-sandbox.workbench.lanit.ru/api/tickets   |
      Также добавить header
        | Content-Type | application/json |
      Тогда отправить запрос
      А статус код 201
      Когда извлечь данные
        | id | $.id |
      То сравнить значения
        | ${id} | != | null |

    Сценарий:Проверка существования созданного тикета

      Когда создать запрос
        | method |                           url                            |
        | GET    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      И добавить header
        | accept | application/json |
      Тогда отправить запрос
      А статус код 200
      Когда извлечь данные
        | resp_title            |      $.title      |
        | resp_submitter_email  | $.submitter_email |
        | resp_id               |       $.id        |
      То сравнить значения
        |        ${id}       | == |        ${resp_id}       |
        |      ${title}      | == |      ${resp_title}      |
        | ${submitter_email} | == | ${resp_submitter_email} |


    Сценарий: Изменение статуса тикета с закрытого на открытый

      Когда сгенерировать переменные
        | status                 |              1              |

      И создать запрос
        | method |       body        |                           url                            |
        |  PUT   | ticket.json | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      Также добавить header
        | Content-Type | application/json |
      Тогда отправить запрос
      А статус код 422
      # Возвращается код 200, вместо 422 или подобной ошибки

    Сценарий: Удаление созданного тикета и его проверка на отсутствие

      Когда создать запрос
        | method |                           url                            |
        | DELETE | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      То отправить запрос
      А статус код 204
      Когда создать запрос
        | method |                           url                            |
        | GET    | https://at-sandbox.workbench.lanit.ru/api/tickets/${id}  |
      И добавить header
        | accept | application/json |
      То отправить запрос
      А статус код 404