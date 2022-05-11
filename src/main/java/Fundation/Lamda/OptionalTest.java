package Fundation.Lamda;

import com.JVM.Animal;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * Created：Jeffrey
 * date   ：2022/5/11 21:09
 */
@Slf4j
public class OptionalTest {

    public static void main(String[] args) {
        //null的处理交给Optional
        Optional<Integer> integer = Optional.ofNullable(null);

        if (integer.isPresent()) {
            System.out.println(integer.get());
        }

        Integer a = integer.isPresent() ? integer.get() : integer.orElse(1);
        integer.orElse(1);

        integer.orElseGet(()->2);
//        integer.orElseThrow()


        Optional<Animal> animal = Optional.of(new Animal()); //不能传null
        animal.get();


    }
}
