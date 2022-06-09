import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class solution {
    //стартовая клетка дана в задании. Определяем линию и колонку как 0:
    static int sL = 0;
    static  int sR = 0;
    // аналогично из задания финальные - 4
    static  int fL = 4;
    static  int fR = 4;


    public static int getResult(String fieldMarkers, String race) {
        int spending = 0; //переменная для хранения затрат. на старт ноль.
        Race.makeRace("Human");
        Race.makeRace("Swamper");
        Race.makeRace("Woodman");
        Point.point[][] field = new Point.point[4][4];
        Point.typeofPoint.initialize(fieldMarkers, field); //создаем и заполняем поле.
        int raceType = Race.findType(race);
        ArrayList<String> history = new ArrayList<String>();// Сюда будет записываться пройденный путь.
        position player = new position(sL, sR);
while(!position.isFinal()){
    spending += makeStep(history, field, raceType);
}
        return spending;
    }


    static int makeStep(ArrayList<String> history, Point.point[][] field, int raceType){
    int line = position.getLine();
    int row = position.getRow();
    if (findBetter(line, row, field, raceType)){
        //шаг вправо
            position.step(1, 0);
    line++;
    }
    else {
        //шаг вниз
        position.step(0, 1);
        row++;
    }
        history.add(line + " " + row);
    return checkCoast(line, row, field, raceType);
}


static int checkCoast(int l, int r, Point.point[][] field, int raceType){
        //узнаем сколько будет стоить шагнуть в выбранную клетку
    Point.typeofPoint place = field[l][r].type;
        return place.getCost(raceType);
}

static int validCheck(int l, int r, String typeSwitcher, Point.point[][] field, int raceType) {
        //-1 так как система считает с нуля
    boolean isValidLine = l < fL-1;
    boolean isValidRow = r < fR-1;
    int Value = 100; //тут большая цифра, что бы при сравнении точно было поражение
    switch (typeSwitcher) {
        case "Line":
            if (isValidLine) {
                Value = checkCoast(l + 1, r, field, raceType);
            }
            break;
        case "Row":
            if (isValidRow) {
                Value = checkCoast(l, r + 1, field, raceType);
            }
            break;
    }
    return Value;
}

static boolean findBetter(int l, int r, Point.point[][] field, int raceType){
        int lineUp = validCheck(l, r, "Line", field, raceType);
        int rowUp = validCheck(l, r, "Row", field, raceType);
        if (lineUp < rowUp) {
            return true;
        } else if (lineUp > rowUp) {
    return false;
        } else {
            //При равном значении затрат на движение вниз и вправо - выбираем случайную клетку
            Random random = new Random();
            return random.nextBoolean();
        }
}


static class position {
    private static int line;
    private static int row;


    position(int sL, int sR){
        //так как инициализируем мы один раз, в начаде, то присвоение стартовых значений именно здесь.
        this.line = sL;
        this.row = sR;
    }

    static int getLine(){
        return line;
    }
    static int getRow(){
        return row;
    }

    static void step(int a, int b){
        line+=a;
        row+=b;
    }

    static  boolean isFinal() {
        if (line < fL-1 || row < fR-1) { //-1 оптому что система считает с нуля
            return false;
        } else {
            return true;
        }
    }
}


}


