package org.example.printer;

/**
 * @author Min Danil 12.10.2023
 */
public class PrinterMenu extends Printer {
    public void printMain() {
        System.out.println(GREEN + "\nВыберите блок работы:");
        System.out.println(PURPLE + "1. Чтение и запись.");
        System.out.println(PURPLE + "2. Создание массива.");
        System.out.println(PURPLE + "3. Работа с массивом.");
        System.out.println(PURPLE + "4. Работа с матрицей.");
        System.out.println(PURPLE + "5. Сортировки матриц.");
        System.out.println(PURPLE + "6. Работа со строками.");
        System.out.println(PURPLE + "7. Работа с графикой.");
        System.out.println(RED + "0. Завершить работу.");
    }

    public void printFirst() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Чтение информации с клавиатуры и вывод на экран.");
        System.out.println(PURPLE + "2. Чтение информации с клавиатуры и запись в файл.");
        System.out.println(PURPLE + "3. Чтение информации из файла и вывод на экран.");
        System.out.println(PURPLE + "4. Чтение информации с клавиатуры и запись в начало файла.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printSecond() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Создание массива и вывод на экран.");
        System.out.println(PURPLE + "2. Чтение массива с клавиатуры и вывод на экран.");
        System.out.println(PURPLE + "3. Создание массива генератором случайных значений и вывод на экран.");
        System.out.println(PURPLE + "4. Создание массива генератором случайных значений в диапазоне.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printThird() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Вывести вектор в обратной последовательности.");
        System.out.println(PURPLE + "2. Отсортировать вектор.");
        System.out.println(PURPLE + "3. Найти минимальное\\максимальное значение.");
        System.out.println(PURPLE + "4. Найти НОД.");
        System.out.println(PURPLE + "5. Сравнение сумм векторов. Вывод вектора с наименьшей суммой.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printQuestions(int flag) {
        switch (flag) {
            case 1:
                System.out.println(GREEN + "Выберите принцип сортировки:");
                System.out.println(PURPLE + "1. Отсортировать по возрастанию.");
                System.out.println(PURPLE + "2. Отсортировать по убыванию.");
                break;
            case 2:
                System.out.println(GREEN + "Выберите цель поиска:");
                System.out.println(PURPLE + "1. Вывести максимум.");
                System.out.println(PURPLE + "2. Вывести минимум.");
                break;
            case 3:
                System.out.println(GREEN + "Выберите формат:");
                System.out.println(PURPLE + "1. По левому краю.");
                System.out.println(PURPLE + "2. По центру.");
                System.out.println(PURPLE + "3. По правому краю.");
                break;
        }
    }

    public void printMatrixBlock() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Создание матрицы.");
        System.out.println(PURPLE + "2. Удаление столбца.");
        System.out.println(PURPLE + "3. Транспонирование матрицы.");
        System.out.println(PURPLE + "4. Вычеркнуть главную диагональ.");
        System.out.println(PURPLE + "5. Замена колонки в матрице.");
        System.out.println(PURPLE + "6. Поиск кратного и замена на 0.");
        System.out.println(PURPLE + "7. Поиск детерминанта матрицы.");
        System.out.println(PURPLE + "8. Умножение матриц.");
        System.out.println(PURPLE + "9. Замена строк матрицы.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printSortBlock() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Сортировка матрицы методом Шелла.");
        System.out.println(PURPLE + "2. Сортировка матрицы методом пузырька.");
        System.out.println(PURPLE + "3. Сортировка матрицы методом вставок.");
        System.out.println(PURPLE + "4. Сортировка матрицы методом выбора.");
        System.out.println(PURPLE + "5. Сортировка матрицы методом кучи.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printFormat() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Вывести форматированный текст.");
        System.out.println(PURPLE + "2. Вывести псевдографикой таблицу.");
        System.out.println(PURPLE + "3. Считать строку из файла. Вычеркнуть из неё символы полученные из клавиатуры.");
        System.out.println(PURPLE + "4. Выполнить поиск строки в файле в режиме не полного соответствия. Вывести номер последней строки удовлетворяющей условию.");
        System.out.println(PURPLE + "5. Вывести строку в формате бегущей строки двигающейся в обратном направлении.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printDraw() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Создать графический объект - квадрат.");
        System.out.println(PURPLE + "2. Вписать треугольник в круг, с радиусом считанным с клавиатуры.");
        System.out.println(PURPLE + "3. Построить гистограмму соответствующую вектору считанному с клавиатуры.");
        System.out.println(PURPLE + "4. Вывести матрицу, пометив цветом только максимальное и минимальное значение.");
        System.out.println(PURPLE + "5. Вывести матрицу считанную из файла, раскрасив строки.");
        System.out.println(PURPLE + "6. Вывести матрицу считанную из файла, раскрасив столбцы.");
        System.out.println(PURPLE + "7. Вывести отсортированную матрицу, раскрасив градиентом.");
        System.out.println(RED + "0. Выйти.");
    }
}
