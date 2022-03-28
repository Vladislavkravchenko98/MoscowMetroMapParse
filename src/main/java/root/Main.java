package root;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    //Создаем поле со ссылкой на ресурс
    private static final String URL = "https://www.moscowmap.ru/metro.html#lines";
    //Поля для Мапы и Листа
    private static TreeMap<String, Line> linemap = new TreeMap();
    private static ArrayList<Station> stations = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //парсинг HTML с помощью jsoup
        Document doc = Jsoup.connect(URL).maxBodySize(0).get();
        //Получаем со всего документа только информацию про конкретный класс
        Elements elements = doc.getElementsByClass("js-metro-line");    //Про линии
        Elements elements2 = doc.getElementsByClass("js-metro-stations"); //Про станции

        // Создаю Линию и кладу в Мапу
        for (Element x : elements) {
            Line line = new Line();
            line.setName(x.text()); //x.text() - нужно чтобы из всей строки взять текст
            String num = getNumberOfLine(x.toString());
            line.setNumber(num);
            linemap.put(num, line);
        }
        //Достаю номер линии, а по номеру кладу станцию в мапу
       for (Element x2 : elements2) {
           Elements elementsByAttribute = x2.getElementsByAttribute("data-metrost"); //Отрезаем лишнее

            for (Element t : elementsByAttribute) {
                    String numberLineOfStation = getNumberAndName(t.toString());
                    String ere = t.getElementsByAttributeValue("class", "name").text();
                    //Создаю объект "станция"
                    Station st = new Station();
                    st.setNumberofline(numberLineOfStation);
                    st.setName(ere);
                    //Сохраняю в Лист
                    stations.add(st);
                    //Сохраняю в Мапу
                   setStations(st);
            }
        }
        //Вывод Мапы в консоль
        for (Map.Entry<String, Line> metroMap : linemap.entrySet()) {
            System.out.println(metroMap.getKey());   //<--Ответ на задание
            for (Station i :  metroMap.getValue().getStationList()) {
                System.out.println(i);
            }
        }
    }
    //Функция - Получаем номер линии
    public static String getNumberOfLine(String x){
        String[] w = x.split("\"");
        return  w[3];
    }
    //Функция - Вытаскимваю из строки название линии на которой находится станция и ищу соответствие в Enum
    public static String getNumberAndName(String a){
        String[] w = a.split("/");
        String[] g = w[2].split("-");
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < g.length; i++){
            sb1.append(g[i]).append("");
        }
        Enum an = Enum.valueOf(sb1.toString());
        return an.getTranslation();
    }
    //Функция - Если номера линий совпадают, то кладу станцию в спиок в Мапе
    public static void setStations(Station b){
        String num_st = b.getNumberOfLine();
        for (Map.Entry<String, Line> m : linemap.entrySet()) {
            if(m.getKey().equals(num_st)){
                if(m.getValue().getStationList() == null){
                    ArrayList<Station> bob = new ArrayList<>();
                    bob.add(b);
                    m.getValue().setStationlist(bob);
                }else{
                    ArrayList<Station> bob =  m.getValue().getStationList();
                    bob.add(b);
                    m.getValue().setStationlist(bob);
                };

            }
        }
    }
}