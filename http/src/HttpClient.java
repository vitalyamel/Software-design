import java.io.*;
import java.net.Socket;
import java.text.ParseException;


public class HttpClient {


    public static void main(String[] args) {
        //Создание потока и чтение данных
        try {
            String header = null;
            if (args.length == 0) {
                header = readHeader(System.in);
            } else {
                FileInputStream fis = new FileInputStream(args[0]);
                header = readHeader(fis);
                fis.close();
            }
            //Вывод заголовка
            System.out.println("Заголовок: \n" + header);
            /* Запрос отправляется на сервер */
            String answer = sendRequest(header);
            /* Ответ выводится на консоль */
            System.out.println("Ответ от сервера: \n");
            System.out.write(answer.getBytes());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.getCause().printStackTrace();
        }
    }

    /**
     * Читает поток и возвращает его содержимое в виде строки.
     * @param strm
     * @return res
     * @throws IOException
     */
    public static String readHeader(InputStream strm) throws IOException {
        /* Из потока считываем в массив данных */
        byte[] buff = new byte[64 * 1024];
        int length = strm.read(buff);
        /* Преобразовываем в строку */
        String res = new String(buff, 0, length);
        return res;
    }

    /**
     * Получает порт и хост и на их основе создает сокет и возвращает ответ от него.
     * Отправляет запрос в соответствии с Http заголовком.
     * @param httpHeader
     * @return ответ от сервера.
     * @throws Exception
     */
    public static String sendRequest(String httpHeader) throws Exception {
        /* Из http заголовка берется арес сервера */
        String host = null;
        int port = 0;
        try {
            // Получаем хост и порт
            host = getHost(httpHeader);
            port = getPort(host);
            host = getHostWithoutPort(host);
        } catch (Exception e) {
            throw new Exception("Не удалось получить адрес сервера.", e);
        }
        /* Отправляется запрос на сервер */
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            System.out.println("Создан сокет: " + host + " port:" + port);
            OutputStream out = socket.getOutputStream();
            out.write(httpHeader.getBytes());
            out.flush();
            System.out.println("Заголовок отправлен. \n");
            /* Возвращается ответ и вызывается метод getAnswer */
            return getAnswer(socket);
        } catch (Exception e) {
            throw new Exception("Ошибка при отправке запроса: "
                    + e.getMessage(), e);
        } finally {
            socket.close();
        }
    }

    /**
     * Ответ от сервера.
     * @param socket
     * @return res
     * @throws Exception
     */
    private static String getAnswer(Socket socket) throws Exception {
        String res = null;
        try {
            //Создание потока записи для сокета
            InputStreamReader isr = new InputStreamReader(socket
                    .getInputStream());
            BufferedReader bfr = new BufferedReader(isr);
            StringBuffer sbf = new StringBuffer();
            //Считывание потока
            int ch = bfr.read();
            while (ch != -1) {
                sbf.append((char) ch);
                ch = bfr.read();
            }
            //Вывод в строку res
            res = sbf.toString();
        } catch (Exception e) {
            throw new Exception("Ошибка при чтении ответа от сервера.", e);
        }
        /* Вовзращаем результат */
        return res;
    }

    /**
     * Выявляет имя хоста (при наличии порта, с портом) из http заголовка.
     * @param header
     * @return res
     * @throws ParseException
     */
    private static String getHost(String header) throws ParseException {
        final String host = "Host: ";
        final String normalEnd = "\n";
        final String msEnd = "\r\n";

        /* Получаем индекс первого вхождения содержимого строки host */
        int s = header.indexOf(host, 0);
        if (s < 0) {
            return "localhost";
        }
        s += host.length();
        /* Получаем индекс первого вхождения содержимого строки normalEnd,
        начиная с индекса s */
        int e = header.indexOf(normalEnd, s);
        /* Получаем индекс первого вхождения содержимого строки msEnd,
        начиная поиск с индекса s */
        e = (e > 0) ? e : header.indexOf(msEnd, s);
        if (e < 0) {
            throw new ParseException(
                    "В заголовке запроса не найдено закрывающих символов после пункта Host.",
                    0);
        }
        /* Получаем имя хоста, удаляем из нее начальные и конечные пробелы */
        String res = header.substring(s, e).trim();
        return res;
    }

    /**
     * Выявляет номер порта.
     * @param hostWithPort
     * @return port
     */
    private static int getPort(String hostWithPort) {
        /* Получаем индекс первого вхождения */
        int port = hostWithPort.indexOf(":", 0);
        /* Получаем порт с помощью полученного индекса нахождения :
        и функции нахождения подстроки */
        port = (port < 0) ? 80 : Integer.parseInt(hostWithPort
                .substring(port + 1));
        return port;
    }

    /**
     * Выявляетт из адреса имя хоста без порта.
     * @param hostWithPort
     * @return хост без порта
     */
    private static String getHostWithoutPort(String hostWithPort) {
        /* Получаем индекс первого вхождения */
        int portPosition = hostWithPort.indexOf(":", 0);
        if (portPosition < 0) {
            return hostWithPort;
        } else {
            return hostWithPort.substring(0, portPosition);
        }
    }
}
