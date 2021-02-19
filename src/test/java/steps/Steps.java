package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.aristovo.framework.managers.PageManager;

public class Steps {
    // менеджер страниц
    private PageManager app = PageManager.getPageManager();

    @Когда("^Загружаем стартовую страницу$")
    public void getStartPageSber() {
        app.getStartPage();
    }

    @Когда("^В основном меню выбираем '(.*)'$")
    public void selectMenuSberBank(String nameMenu) {
        app.getStartPage().selectMenuSber(nameMenu);
    }

    @Когда("^В открывшемся подменю выбираем '(.*)'$")
    public void selectSubMenuSberBank(String nameSubMenu) {
        app.getStartPage().selectSubMenuSber(nameSubMenu);
    }

    @Тогда("^Проверяем заголовок открывшейся страницы '(.*)'$")
    public void checkedOpenPageIpoteka(String title) {
        app.getIpotekaCalcPage().checkedTitlePage(title);
    }

    @Когда("^Прокручиваем страницу до калькулятора$")
    public void scrollTOCalculateSberIpoteka() {
        app.getIpotekaCalcPage().scrollToCalculatorAnsSelectFrame();
    }

    @Когда("^Заполняем параметры желаемого кредита$")
    public void inputDataCredit(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getIpotekaCalcPage().fillFieldInCalculator(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("^Прокручиваем до выбора дополнительных услуг$")
    public void scrollAddServSber () {
        app.getIpotekaCalcPage().scrollByButtonIssue();
    }

    @Когда("^Подключаем или отключаем дополнительные услуги$")
    public void selectAddServSber(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getIpotekaCalcPage().selectAddServ(raw.get(0), raw.get(1));
                }
        );
    }

    @Тогда("^Проверяем правильность расчета калькулятора$")
    public void checkCalc (DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getIpotekaCalcPage().checkedFieldCalc(raw.get(0), raw.get(1));
                }
        );
    }



}
