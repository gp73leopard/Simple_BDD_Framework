#language:ru
  @HelpDeskTicketCreate
  Функция: Создание тикета

    Сценарий: Создание тикета с высоким приоритетом

      Когда открыть url "https://at-sandbox.workbench.lanit.ru"
      И инициализация страницы "HelpDesk"
      То кликнуть на элемент "создание нового тикета"
      Когда переход на страницу "создание тикета"
      И на странице имеется элемент "наименование тикета"
      То выбрать из списка "очередь" опцию "Django Helpdesk"
      И ввести в поле "наименование тикета" значение "asdfadsfafasfafas2"
      Также ввести в поле "почта" значение "asdfadsfafasfafasshdsdf@mail.ru"
      К тому же выбрать из списка "приоритет" опцию "2. High"
      И кликнуть на элемент "кнопка создания нового тикета"
