package lambdaPractice;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * Created by Divya.Gupta on 22-02-2017.
 */
public class LambaTest1 {

    private static final List<String> listStr = initList();

    private static List<String> initList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            list.add(i + "STR" + (i % 10));
        }
        print(list);
        return list;
    }

    public static enum CounterNames {
        // Contact Events Counters
        CONTACT_EVENTS_RECIEVED, CONTACT_EVENTS_VALIDATION_ERROR,
        CONTACT_EVENTS_JSON_ERROR, CONTACT_EVENTS_SUCCESS,
        // Detail View Events Counters
        DETAILVIEW_EVENTS_RECIEVED, DETAILVIEW_EVENTS_VALIDATION_ERROR,
        DETAILVIEW_EVENTS_JSON_ERROR, DETAILVIEW_EVENTS_SUCCESS,
        // Requirement Events Counters
        REQMT_EVENTS_RECIEVED, REQMT_EVENTS_VALIDATION_ERROR,
        REQMT_EVENTS_JSON_ERROR, REQMT_EVENTS_SUCCESS,
        // Search Events Counters
        SEARCH_EVENTS_RECIEVED, SEARCH_EVENTS_VALIDATION_ERROR,
        SEARCH_EVENTS_JSON_ERROR, SEARCH_EVENTS_SUCCESS,
        // Mail Sent Events Counters
        MAILSENT_EVENTS_RECIEVED, MAILSENT_EVENTS_VALIDATION_ERROR,
        MAILSENT_EVENTS_JSON_ERROR, MAILSENT_EVENTS_SUCCESS,
        // Mail Open Events Counters
        MAILOPEN_EVENTS_RECIEVED, MAILOPEN_EVENTS_VALIDATION_ERROR,
        MAILOPEN_EVENTS_JSON_ERROR, MAILOPEN_EVENTS_SUCCESS,
        // NotificationSentBean Events Counters
        NOTIFICATION_SENT_EVENTS_RECIEVED,
        NOTIFICATION_SENT_EVENTS_VALIDATION_ERROR,
        NOTIFICATION_SENT_EVENTS_JSON_ERROR, NOTIFICATION_SENT_EVENTS_SUCCESS,
        // Notification Open Event Counters
        NOTIFICATION_OPEN_EVENTS_RECIEVED,
        NOTIFICATION_OPEN_EVENTS_VALIDATION_ERROR,
        NOTIFICATION_OPEN_EVENTS_JSON_ERROR, NOTIFICATION_OPEN_EVENTS_SUCCESS,
        // Shortlist Events Counters
        SHORTLIST_EVENTS_RECIEVED, SHORTLIST_EVENTS_VALIDATION_ERROR,
        SHORTLIST_EVENTS_JSON_ERROR, SHORTLIST_EVENTS_SUCCESS,
        // Shortlist Events Counters
        COMPARE_EVENTS_RECIEVED, COMPARE_EVENTS_VALIDATION_ERROR,
        COMPARE_EVENTS_JSON_ERROR, COMPARE_EVENTS_SUCCESS,
        // AS and BD Counters
        ASandBD_EVENTS_RECIEVED, ASandBD_EVENTS_VALIDATION_ERROR,
        ASandBD_EVENTS_JSON_ERROR, ASandBD_EVENTS_SUCCESS,
        generalInfoUpdate, staticInfoUpdate, scoringInfoUpdate;
    }
    public static void main(String[] args) {
        for(Object name : CounterNames.values()){
            System.out.println(name.toString());
        }
    }
    /**
     * @param args
     */
    public static void main1(String[] args) {
        /**
         * all:first are digits <br>
         * java.util.stream.Stream.allMatch(Predicate<? super String> predicate)
         */
        print("allMatch:firstAreDigits-->" + listStr.stream()
                .allMatch(data -> Character.isDigit(data.charAt(0))));
        /**
         * all: first and last are digits <br>
         * java.util.stream.Stream.allMatch(Predicate<? super String> predicate)
         */
        print("allMatch:firstAndLastAreDigits" + listStr.stream().allMatch(
                data -> Character.isDigit(data.charAt(data.length() - 1))));

        /**
         * any: first 3 are digit 100*
         * java.util.stream.Stream.anyMatch(Predicate<? super String> predicate)
         */
        print("anyMatch:first 3 are digits-->" + listStr.stream()
                .anyMatch(data -> Character.isDigit(data.charAt(0))
                        && Character.isDigit(data.charAt(1))
                        && Character.isDigit(data.charAt(2))));

        /**
         * collect data as list <br>
         * java.util.stream.Collectors.toList()
         */
        List<String> newList = listStr.stream().collect(toList());
        print("dataAs List-->" + newList);

        /**
         * collect data as set <br>
         *
         * {@link java.util.stream.Collectors.toSet()}
         */
        Set<String> newSet = listStr.stream().collect(toSet());
        print("data as Set-->" + newSet);

        /**
         * collect as newmap<str,str.lastChar> <br>
         *
         * Collectors.toMap(Function<? super Object, ? extends Object>
         * keyMapper, Function<? super Object, ? extends Object> valueMapper)
         */
        Map<String, String> newMap = listStr.stream()
                .collect(toMap(Function.identity(), dataStr -> String
                        .valueOf(dataStr.charAt(dataStr.length() - 1))));
        print("Map<str,str.lastChar>-->" + newMap);

        /**
         * collect as newmap<str.first3Char,str> <br>
         * Collectors.toMap(Function<? super Object, ? extends Object>
         * keyMapper, Function<? super Object, ? extends Object> valueMapper)
         */
        Map<String, String> newMapInverse = listStr.stream().collect(
                toMap(dataStr -> dataStr.substring(0, 3), Function.identity()));
        print("Map<str.first3Char,str>-->" + newMapInverse);

        /**
         * collect as newmap<str.first3char,str.lastChar> <br>
         *
         * @see Collectors.toMap(Function<? super Object, ? extends Object>
         *      keyMapper, Function<? super Object, ? extends Object>
         *      valueMapper)
         */

        Map<String, String> newMap2 = listStr.stream().collect(
                toMap(dataStr -> dataStr.substring(0, 3), dataStr -> String
                        .valueOf(dataStr.charAt(dataStr.length() - 1))));
        print("Map<str.first3char,str.lastChar>-->" + newMap2);

        /**
         * collect as Map<str.lastChar,all strs that match the str.lastChar>
         * <br>
         * Collectors.toMap(Function<? super Object, ? extends Object>
         * keyMapper, Function<? super Object, ? extends Object> valueMapper,
         * BinaryOperator<Object> mergeFunction)
         */
        Map<String, String> newMap3 = listStr.stream()
                .collect(toMap(
                        dataStr -> String
                                .valueOf(dataStr.charAt(dataStr.length() - 1)),
                        Function.identity(),
                        (val1, val2) -> val1 + ":" + val2));
        print("Map<str.lastChar,all strs that match the str.lastChar>-->"
                + newMap3);

        // collect as Map<str.firstChar,all strs starting from str.firstChar>
        // Collectors.toMap(Function<? super Object, ? extends Object>
        // keyMapper, Function<? super Object, ? extends Object> valueMapper,
        // BinaryOperator<Object> mergeFunction)
        Map<String, String> newMap4 = listStr.stream()
                .collect(toMap(dataStr -> String.valueOf(dataStr.charAt(0)),
                        Function.identity(),
                        (val1, val2) -> val1 + " & " + val2));
        print("Map<str.firstChar,all strs starting from str.firstChar>-->"
                + newMap4);

        // collect Map<str.firstChar,all strs starting from str.firstChar> to
        // newMap where newMap<IntegerAtFirstPos,all strings with startPos>
        // Collectors.toMap(Function<? super Object, ? extends Object>
        // keyMapper, Function<? super Object, ? extends Object> valueMapper)
        Map<Integer, String> newMap5 = newMap4.entrySet().stream()
                .collect(toMap(entry -> Integer.parseInt(entry.getKey()),
                        entry -> Arrays
                                .toString(entry.getValue().split(" & "))));
        print("Map<IntegerAtFirstPos,all strings with startPos>-->" + newMap5);

        print("CurrentData-->" + listStr);

        // Map<IntAtPos1,allMatchingStrs> with new Map supplier:LinkedHashMap
        // Collectors.toMap(Function<? super Object, ? extends Object>
        // keyMapper, Function<? super Object, ? extends Object> valueMapper,
        // BinaryOperator<Object> mergeFunction, Supplier<Map<Object, Object>>
        // mapSupplier)
        Map<Integer, String> newLinkedMap = listStr.stream()
                .collect(toMap(
                        dataStr -> Integer.parseInt(dataStr.substring(0, 1)),
                        Function.identity(), (val1, val2) -> val1 + ":" + val2,
                        LinkedHashMap::new));
        print("Map<IntAtPos1,allMatchingStrs> using MapSupplier-->"
                + newLinkedMap);

        // Average of all the firstChars as double
        // Collectors.averagingDouble(ToDoubleFunction<? super Object> mapper)
        double avgOfFirstChars_double = listStr.stream()
                .collect(averagingDouble(
                        dataStr -> Double.parseDouble(dataStr.substring(0, 1))))
                .doubleValue();
        print("double_avg-->" + avgOfFirstChars_double);

        // Average of all the firstChars as Int
        // Collectors.averagingInt(ToIntFunction<? super Object> mapper)
        int avgOfFirstChars_int = listStr.stream()
                .collect(averagingInt(
                        dataStr -> Integer.parseInt(dataStr.substring(0, 1))))
                .intValue();
        print("integer_avg-->" + avgOfFirstChars_int);

        // Average of all the firstChars as Long
        // Collectors.averagingLong(ToLongFunction<? super Object> mapper)
        long avgOfFirstChars_long = listStr.stream()
                .collect(averagingLong(
                        dataStr -> Long.parseLong(dataStr.substring(0, 1))))
                .longValue();
        print("long_avg-->" + avgOfFirstChars_long);

        // Collect all elements as oneLargeString
        // Stream.collect(Supplier<Object> supplier, BiConsumer<Object, ? super
        // String> accumulator, BiConsumer<Object, Object> combiner)
        String allAsOneString = listStr.stream().collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append).toString();
        print("AllAsOneString-->" + allAsOneString);

        // UnmodifiableMap<dataStr.firstChar,Matching dataStrs>
        // Collectors.collectingAndThen(Collector<Object, ?, Map<Object,
        // Object>> downstream, Function<Map<Object, Object>, Object> finisher)
        Map<String, String> unmodifiableMap = listStr.stream()
                .collect(collectingAndThen(
                        toMap(dataStr -> dataStr.substring(0, 1),
                                Function.identity(),
                                (dataStr1, dataStr2) -> dataStr1 + ":"
                                        + dataStr2),
                        Collections::unmodifiableMap));
        print("UnmodifiableMap<firstChar,fullStr>-->" + unmodifiableMap);

        // counting iterator gives count
        // Collectors.counting()
        long Val = listStr.stream().collect(counting()).longValue();
        print("Counting Iteraor:COUNT--->" + Val);

        // map<firstIntOfStr,ListOfAllStrStartingFromThisInt>
        // Collectors.groupingBy(Function<? super Object, ? extends Object>
        // classifier)
        Map<Integer, List<String>> groupByFirstDigit = listStr.stream()
                .collect(groupingBy(
                        dataStr -> Integer.parseInt(dataStr.substring(0, 1))));
        print("GroupByFirstDigit-->" + groupByFirstDigit);

        /**
         * Map
         * <Last4Char,ListOf(uniqStrsGroupedByLast4Chars-trimmedTofirst4hars)>
         * <br>
         * Collectors.groupingBy(Function<? super Object, ? extends Object>
         * classifier, Collector<? super Object, ?, Set<Object>> downstream)
         */
        Map<String, Set<String>> groupByMap2 = listStr.stream().collect(
                groupingBy(dataStr -> dataStr.substring(dataStr.length() - 4),
                        Collectors.mapping(dataStr -> dataStr.substring(0, 4),
                                toSet())));
        print("Map<Last4Char,SetForAllGroupedBy[last4Char]andtrimmedToFirst4Char>-->"
                + groupByMap2);

        /**
         * Map<Last4Chars,GroupedByLast4Replaced'STR'By'-'> <br>
         * Giving MapperFactor as: LinkedHashMap<> <br>
         *
         * Collectors.groupingBy(Function<? super Object, ? extends Object>
         * classifier, Supplier<Map<Object, Set<Object>>> mapFactory,
         * Collector<? super Object, ?, Set<Object>> downstream)
         */
        Map<String, Set<String>> groupByMap3 = listStr.stream()
                .collect(
                        Collectors.groupingBy(
                                dataStr -> dataStr.substring(
                                        dataStr.length() - 4),
                                LinkedHashMap::new,
                                Collectors.mapping(
                                        dataStr -> dataStr.replaceAll("STR", "-"),
                                        toSet())));
        print("Map<Last4Chars,GroupedByLast4Replaced'STR'By'-'>-->"
                + groupByMap3);

        /**
         * Join all the elements togethor into String
         * java.util.stream.Collectors.joining()
         */
        String allInOne = listStr.stream().collect(Collectors.joining());
        print("AllInOneJoined-->" + allInOne);

        /**
         * Join all the elements togethor into String, delimited by '*'
         * java.util.stream.Collectors.joining(CharSequence delimiter)
         */
        String allInOneDelimited = listStr.stream()
                .collect(Collectors.joining("*"));
        print("allInOneJoined&Delimited-->" + allInOneDelimited);

        /**
         * Join all the elements togethor with: <br>
         * -- delimiter: '~' <br>
         * -- prefix: 'Ketan-' <br>
         * -- suffix: '-Dikshit'
         *
         * Collectors.joining(CharSequence delimiter, CharSequence prefix,
         * CharSequence suffix)
         */
        String allInOneDelimiedWithPrefixAndSuFFix = listStr.stream()
                .collect(Collectors.joining("~", "Ketan-", "-Dikshit"));
        print("allInOneDelimiedWithPrefixAndSuFFix-->"
                + allInOneDelimiedWithPrefixAndSuFFix);

        /**
         * Converted the listOfStrings to a set(unique) of number by taking its
         * last digit from each string <br>
         *
         * Collectors.mapping(Function<? super Object, ? extends Object> mapper,
         * Collector<? super Object, ?, Set<Object>> downstream)
         */
        Set<Integer> lastNumbersList = listStr.stream()
                .collect(mapping(
                        dataStr -> Integer.parseInt(
                                dataStr.substring(dataStr.length() - 1)),
                        toSet()));
        print("LastNumberUniqueList-->" + lastNumbersList);

        /**
         * Find masString based on some logic(BasedOnString'sLastInt) <br>
         *
         * Collectors.maxBy(Comparator<? super Object> comparator)
         */
        String maxString = listStr.stream()
                .collect(maxBy(Comparator.comparing(dataStr -> Integer
                        .parseInt(dataStr.substring(dataStr.length() - 1)))))
                .get();
        print("Max-String(BasedOnStringsLastInt)-->" + maxString);

        /**
         * Find minString based on some logic(BasedOnString'sLastInt) <br>
         *
         * Collectors.minBy(Comparator<? super Object> comparator)
         */
        String minStr = listStr.stream()
                .collect(minBy(Comparator.comparing(dataStr -> Integer
                        .parseInt(dataStr.substring(dataStr.length() - 1)))))
                .get();
        print("Min-String(BasedOnStringsLastInt)-->" + minStr);

        /**
         * Partioning the dataSet based on predicate Logic(last integer < 5)
         * Collectors.partitioningBy(Predicate<? super Object> predicate)
         *
         */
        Map<Boolean, List<String>> partionedByPredicateMap = listStr.stream()
                .collect(Collectors.partitioningBy(dataStr -> Integer.parseInt(
                        dataStr.substring(dataStr.length() - 1)) < 5));
        print("Predicate(TRUE)-->" + partionedByPredicateMap.get(true).size()
                + ",Predicate(FALSE)-->"
                + partionedByPredicateMap.get(false).size() + " TotalMap-->"
                + partionedByPredicateMap);

        /**
         * Partioning the dataSet by predicate logic(last integer < 5) and then
         * transforming the partioned data(dataStr-->lastInt) before output by
         * applying the downstream function(Collectors.mappping)
         *
         * Collectors.partitioningBy(Predicate<? super Object> predicate,
         * Collector<? super Object, ?, Set<Object>> downstream)
         */
        Map<Boolean, Set<Integer>> partionedByPredicateAndMappedMap = listStr
                .stream().collect(
                        partitioningBy(
                                dataStr -> Integer.parseInt(dataStr
                                        .substring(dataStr.length() - 1)) < 5,
                                mapping(dataStr -> Integer.parseInt(
                                                dataStr.substring(dataStr.length() - 1)),
                                        toSet())));
        print("PartionedByPredicateAndMappedtoLastInt-->"
                + partionedByPredicateAndMappedMap);

        /**
         * Util Comparator for dataStr <br>
         * Sorts by lastIntOfString
         */
        Comparator<String> dataStrComparator = Comparator
                .comparing(dataStr -> Integer
                        .parseInt(dataStr.substring(dataStr.length() - 1)));

        /**
         * Reduces the dataSet by finding Out the min from the set using
         * comparator <br>
         *
         * Collectors.reducing(BinaryOperator<String> op) and
         * BinaryOperator.minBy(Comparator<? super String> comparator)
         */
        String reducedStringMin = listStr.stream()
                .collect(reducing(BinaryOperator.minBy(dataStrComparator)))
                .get();
        print("ReducedStringMinimal-->" + reducedStringMin);

        /**
         * Reduces the dataSet by finding Out the max(but min by reversing the
         * comparator) from the set using comparator<br>
         *
         * Collectors.reducing(BinaryOperator<String> op) and
         * BinaryOperator.maxBy(Comparator<? super String> comparator)
         */
        String reducedStringMaxButStillMin = listStr.stream()
                .collect(reducing(
                        BinaryOperator.maxBy(dataStrComparator.reversed())))
                .get();
        print("ReducedStringMaximal(but stillMinimal)-->"
                + reducedStringMaxButStillMin);

        /**
         * Reduces the string data Set by adding all the last ints of the String
         * and transforming them back to String( Sum still turns out to be Zero:
         * Find Out Why ?? ;) ) <br>
         * Collectors.reducing(BinaryOperator<Object> op)
         */
        String reducedString2 = listStr.stream()
                .collect(reducing((dataStr1,
                                   dataStr2) -> String.valueOf(Integer
                        .parseInt(dataStr1.substring(
                                dataStr1.length() - 1))
                        + Integer.parseInt(
                        dataStr2.substring(dataStr2.length() - 1)))))
                .get();
        print("ReduceByAddingAllLastInts-->" + reducedString2);

        /**
         * Ok, this is long one(But very useful) The functionality here is
         * actually same as prevoius one ie; Reduce the dataSet by continously
         * adding the last integer from each String from dataSet; <br>
         * Then howz it different ?? <br>
         * Lets see what the api says: <br>
         *
         * The reducing() collectors are most useful when used in a multi-level
         * reduction, downstream of groupingBy or partitioningBy. To perform a
         * simple reduction on a stream, use Stream.reduce(Object,
         * BinaryOperator)} instead.<br>
         * example: For example, given a stream of Person, to calculate the
         * longest last name of residents in each city.
         *
         * Comparator<String> byLength = Comparator.comparing(String::length);
         * Map<City, String> longestLastNameByCity =
         * people.stream().collect(groupingBy(Person::getCity,
         * reducing(Person::getLastName,BinaryOperator.maxBy(byLength) )));
         *
         * So that means when we have grouped the persons by city, then out of
         * all those persons in the city we reduce them, by finding the longest
         * name 'out of all names'.
         *
         * Thus this variant of reducing(reducing(String identity,
         * BinaryOperator<String> op)) needs to evaluate identity of the grouped
         * by data; But in our example we don't have grouped by data so we need
         * to give identity new data whenever it gets evaluated by doing
         * something: So what we do:<br>
         * listStr.get(indexer.getAndIncrement()) <br>
         * , so this would provide it with with a new string always, to do the
         * reduction. I hope this is clear, if not KD says don't worry
         */
        AtomicInteger indexer = new AtomicInteger(0);
        String whatIs = listStr.stream().collect(reducing(
                listStr.get(indexer.getAndIncrement()),
                (dataStr1, dataStr2) -> String.valueOf(Integer
                        .parseInt(dataStr1.substring(dataStr1.length() - 1))
                        + Integer.parseInt(
                        dataStr2.substring(dataStr2.length() - 1)))));
        print("ReducerLastDigitSumWitType-->" + whatIs);
        indexer.set(0);

        /**
         * Similar as above, ut we have a mapper as weel, so we get data, map it
         * to something, before starting the reduction
         *
         *
         * Collectors.reducing(String identity, Function<? super Object, ?
         * extends String> mapper, BinaryOperator<String> op)
         */
        String str = listStr.stream().collect(
                reducing(listStr.get(indexer.getAndIncrement()), dataStr -> {
					/* System.out.println("Mapper-->" + dataStr); */
                    return dataStr;
                } , (dataStr1, dataStr2) -> {
                    int val1 = Integer.parseInt(
                            dataStr1.substring(dataStr1.length() - 1));
                    int val2 = Integer.parseInt(
                            dataStr2.substring(dataStr2.length() - 1));
                    int total = val1 + val2;
					/*
					 * System.out.println("Val1=" + val1 + ", Val2=" + val2 +
					 * " Total:" + total);
					 */
                    return String.valueOf(total);
                }));

        print("ReducerLastDigitSumWitTypeAndMapper-->" + str);

        /**
         * All double-stats are collected from the stream by providing the key
         * as double for each input element
         */
        print("DoubleStats-->" + listStr.stream()
                .collect(summarizingDouble(dataStr -> Double.parseDouble(
                        dataStr.substring(dataStr.length() - 1)))));

        /**
         * All int-stats are collected from the stream by providing the key as
         * integer for each input element
         */
        print("IntStats-->"
                + listStr.stream().collect(summarizingInt(dataStr -> Integer
                .parseInt(dataStr.substring(dataStr.length() - 1)))));

        /**
         * All long-stats are collected from the stream by providing the key as
         * long for each input element
         */
        print("LongStats-->"
                + listStr.stream().collect(summarizingLong(dataStr -> Long
                .parseLong(dataStr.substring(dataStr.length() - 1)))));

        /**
         * Sum of all the doubles, extracted by your doubleExtractor function to
         * bee applied on each input;<br>
         * 0+1+2+....+9=45 <br>
         * Doing this 10 times: 45*10=450
         */
        print("SummingDouble-->" + listStr.stream()
                .collect(Collectors.summingDouble(dataStr -> Double.parseDouble(
                        dataStr.substring(dataStr.length() - 1)))));

        /**
         * Sum of all the ints, extracted by your intsExtractor function to bee
         * applied on each input;<br>
         * 0+1+2+....+9=45 <br>
         * Doing this 10 times: 45*10=450
         */
        print("SummingInts-->" + listStr.stream()
                .collect(Collectors.summingInt(dataStr -> Integer
                        .parseInt(dataStr.substring(dataStr.length() - 1)))));

        /**
         * Sum of all the longs, extracted by your longsExtractor function to
         * bee applied on each input;<br>
         * 0+1+2+....+9=45 <br>
         * Doing this 10 times: 45*10=450
         */
        print("SummingLongs-->" + listStr.stream()
                .collect(Collectors.summingLong(dataStr -> Long
                        .parseLong(dataStr.substring(dataStr.length() - 1)))));

        /**
         * Add all the strings in the stream to new container: StringBuilder by
         * appending one to another to get a single resultant string <br>
         *
         * Stream.collect(Supplier<Object> supplier, BiConsumer<Object, ? super
         * String> accumulator, BiConsumer<Object, Object> combiner)
         */
        String strBldr = listStr.stream().collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append).toString();
        print("ConcatAll-->" + strBldr);

        /**
         * Stream.count() giives the count of elements in dataSet
         */
        print("Count-->" + listStr.stream().count());

        /**
         * Stream.distinct() gives the count for only unique elements based on
         * equals(@see boolean Object.equals(Object) ) method.
         */
        print("CountDistinct-->" + listStr.stream().distinct().count());

        /**
         * Filter the dataSet using a predicate(firstChar==lastChar)
         *
         * Stream.filter(Predicate<? super String> predicate)
         */
        List<String> filteredList = listStr.stream()
                .filter(dataStr -> dataStr
                        .charAt(dataStr.length() - 1) == dataStr.charAt(0))
                .collect(toList());
        print("FilteredList-->" + filteredList);

        print("findAny-->" + listStr.stream().findAny().get());

        /**
         * Find any and return that if it matches Predicate else throw
         * exception(NoSuchElementFound exceptipon)
         */
        print("anyStrAndIsItsLastChar0-->" + listStr.stream().findAny()
                .filter(dataStr -> dataStr.charAt(dataStr.length() - 1) == '0')
                .get());

        /**
         * FindAny, and if that matches predicate, return it, else return my
         * provided element <br>
         * Stream.findAny() <br>
         * Optional.filter(Predicate<? super String> predicate) <br>
         * Optional.orElse(String other)
         */
        print("findAnyIfNotMatchPredicateThenKetan="
                + listStr.stream().findAny()
                .filter(dataStr -> dataStr
                        .charAt(dataStr.length() - 1) == 'N')
                .orElse("Ketan"));

        print("firstStr-->" + listStr.stream().findFirst().get());

        /**
         * Split cah element in dataSet by 'STR' so we get 2 elements from each
         * elements and then collect al the unique ones toogethor
         *
         * Stream.flatMap(Function<? super String, ? extends Stream<? extends
         * Object>> mapper)
         */
        Set<String> flatmapStrs = listStr.stream()
                .flatMap(dataStr -> Stream.of(dataStr.split("STR")))
                .collect(toSet());
        print("flatmapStrs-->" + flatmapStrs);

        double countDoublesSum = listStr.stream()
                .flatMapToDouble(dataStr -> DoubleStream.of(Double
                        .parseDouble(dataStr.substring(dataStr.length() - 1))))
                .sum();
        print(countDoublesSum);

        int countIntsSum = listStr.stream()
                .flatMapToInt(dataStr -> IntStream.of(Integer
                        .parseInt(dataStr.substring(dataStr.length() - 1))))
                .sum();
        print(countIntsSum);

        long countLongsSum = listStr.stream()
                .flatMapToLong(dataStr -> LongStream.of(Long
                        .parseLong(dataStr.substring(dataStr.length() - 1))))
                .sum();
        print(countLongsSum);

        final List<String> newListAgain = new ArrayList<>(10);
        listStr.stream().forEach(dataStr -> {
            newListAgain.add(dataStr.replace("STR", "-Ketan-"));
        });
        print("ModifiedList-->" + newListAgain);
    }

    public static <T> void print(T type) {
        System.out.println(type);
    }

}
