package utils;

public interface Constants {

    interface ROOM{
        String TYPE = "Phòng ";
        String DOT = ".";
        String AREA = " mét vuông";
        String PRICE = " giá ";
    }

    interface STATUS{
        Integer ACTIVATED = 1;
        Integer DELETED = 0;
    }

    interface SENTENCES{
        String POSITION = "Địa điểm: ";
    }

    interface DEVICE{
        String TABLE = "Bàn";
        String CHAIR = "Ghế";
        String SPEAKER = "Loa";
        String RADIO = "Đài";
        String PROJECTOR = "Máy chiếu";
    }
}
