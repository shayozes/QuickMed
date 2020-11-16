const selectors = {
    quizAnswer: '.appsMaterialWizToggleRadiogroupRadioButtonContainer',
    quizSubmitButton: '.freebirdFormviewerViewNavigationSubmitButton',
};

const clickOnElement = (elementQuery, index) => {
    if (index) {
        document.querySelectorAll(elementQuery)[index].click();
    } else {
        document.querySelector(elementQuery).click();
    }
};

const clickOnQuizAnswer = (index) => {
    clickOnElement(selectors['quizAnswer'], index);
};

const clickOnQuizSubmitButton = () => {
    clickOnElement(selectors['quizSubmitButton']);
};