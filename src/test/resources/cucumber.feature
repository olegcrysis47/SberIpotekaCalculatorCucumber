#language: ru

@all
#noinspection NonAsciiCharacters
Функционал: Оформление ипотеки

  @smoke
  @ipoteka
  Сценарий: Заполнение и проверка ипотечного калькулятора
    * Загружаем стартовую страницу
    * В основном меню выбираем 'ипотека'
    * В открывшемся подменю выбираем 'Ипотека на готовое жильё'
    * Проверяем заголовок открывшейся страницы 'Ипотека от 7,3%* на готовые квартиры'
    * Прокручиваем страницу до калькулятора
    * Заполняем параметры желаемого кредита
      | Стоимость недвижимости         | 5 180 000     |
      | Первоначальный взнос           | 3 058 000     |
      | Срок кредита                   | 30            |
    * Прокручиваем до выбора дополнительных услуг
    * Подключаем или отключаем дополнительные услуги
      | Скидка 0,3% при покупке квартиры на ДомКлик | false |
      | Страхование жизни и здоровья                | false |
      | Молодая семья                               | true  |
      | Электронная регистрация сделки              | false |
    * Проверяем правильность расчета калькулятора
      | Ежемесячный платеж | 16 922 ₽     |
      | Сумма кредита      | 2 122 000 ₽  |
      | Необходимый доход  | 21 784 ₽     |
      | Процентная ставка  | 8,9%         |