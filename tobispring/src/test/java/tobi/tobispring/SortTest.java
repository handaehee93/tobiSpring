package tobi.tobispring;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTest {

    Sort sort;
    @BeforeEach
    void beforeEach () {
        sort = new Sort();
    }

    @Test
    void sort(){
        // 준비(테스트를 위한 인스턴스 생성이나 db연결), 현재는 beforeEach 메서드에서 수행

        // 실행
        List<String> testList = new ArrayList<>();
        testList.add("aa");
        testList.add("b");
        List<String> result = sort.sortByLength(testList);
        // 검증
        Assertions.assertThat(result).isEqualTo(List.of("b","aa"));
    }

    @Test
    void sort2(){
        // 준비(테스트를 위한 인스턴스 생성이나 db연결), 현재는 beforeEach 메서드에서 수행

        // 실행
        List<String> testList = new ArrayList<>();
        testList.add("aa");
        testList.add("ccc");
        testList.add("b");
        List<String> result = sort.sortByLength(testList);
        // 검증
        Assertions.assertThat(result).isEqualTo(List.of("b","aa","ccc"));
    }
}
