package com.mygroup.constructor;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @ClassName: ListPlayController
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/27
 * @Version 1.0
 */


@Component
public class ListPlayController {

    private List<MorePlayDao> goPlays;//这里存的是FirstOne和SecondOne

    public ListPlayController(List<MorePlayDao> goPlays) {
        this.goPlays = goPlays;
    }

    public void listPlay(){
        goPlays.forEach(goPlay -> goPlay.someOnePlay());
    }

}
