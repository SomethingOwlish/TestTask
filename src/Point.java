import java.util.HashMap;

public class Point {
    //переменная заложена для сбора данных о типах из файла и корректного определения программой.
     static HashMap<Character, typeofPoint> ListofType = new HashMap<Character, typeofPoint>();

    // enum из типов клетов и затрат на хождения по ним
  enum typeofPoint {
        //сразу заготовка под чтение с файла - типы названы обезличено, прописаны пока значения, потом перестрою на обезличное, если успею.
        firstPointType("water", 2, 2, 3, 'W'),
        secondPointType("thicket", 3, 5, 2, 'T'),
        thirdPointType("swap", 5, 2, 3, 'S'),
        forthPointType("plate", 1, 2, 2, 'P');

        //переменные для каждого типа клетки - название, цена для каждого типа существ
        private  String title;
        private int raceOneCost; //По умолчанию человек
        private int raceTwoCоst; //по умолчанию болотник
        private int raceThreCost; //по умолчанию леший

        //получить название типа
        String getTitle() {
            return title;
        }


        // конструктор для создания типа. так же обезличен. Выше есть значения по умолчанию.
        typeofPoint(String title, int fCost, int sCost, int tCost , char firstLitera ) {
            this.title = title;
            this.raceOneCost = fCost;
            this.raceTwoCоst = sCost;
            this.raceThreCost = tCost;
            ListofType.put(firstLitera, typeofPoint.this);
        };

       static void initialize(String fieldMarkers,  point[][] field) {
            char[] ch=fieldMarkers.toCharArray();
            int n = 0; //итератор, нужен дальше
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    field[i][j] = new point(i,j,ch[n]);
                    n++;
                }
            }
        }

        // получить значение клетким для типа расы

        int getCost(int raceType) {
            if (raceType == 1) {
                return raceOneCost;
            } else if (raceType == 2) {
                return raceTwoCоst;
            } else {
                return raceThreCost;
            }
        }



        @Override
        public String toString() {
            return  title;
        }


    }

static typeofPoint selectType(char type) {
//метод что бы из перечисления получить нужное нам значение.
        return ListofType.get(type);
    }

    // Класс каждой единицы в нашем массиве из строк
    static class point {
        int line;
        int row;
       typeofPoint type;

        point(int line, int row, char type) {
            this.line = line;
            this.row = row;
            this.type = selectType(type);

        }

    }
}
