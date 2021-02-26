import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.math.RoundingMode;
import java.util.*;

public class ElTest {
    public static void main(String[] args) {
        //基本使用
        //basicUse();
        //文本表达式
        //textExpression();
        //对象属性
        //objectProperty();
        //访问数组
        //array();
        //访问list
        //list();
        //访问map
        //map();
        //内置列表
        //builtInList();
        //构建数组
        //builtArray();
        //方法调用
        //methodInvoke();
        //关系运算符
        //relationOperator();
        //逻辑运算符
        //logicOperator();
        //算术运算符
        //arithmeticOperator();
        //赋值
        //assign();
        //类型
        //type();
        //构造器
        //construct();
        //变量
        variable();
        //三元运算符
        //ternaryOperator();
        //安全导航操作
        //safeNavigationOperator();
        //集合选择
        //collectionSelect();
        //集合投影
        //collectionMap();
        //模板表达式
        //templateExpr();
        //访问字典类型Dictionary(Properties)
        //accessDictionary();
    }

    /**
     * 基本使用
     */
    private static void basicUse() {
        String spel = "125L";
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(spel);
        Object value = exp.getValue();
        System.out.println(value.getClass());
        System.out.println(value);
    }

    /**
     * 文本表达式
     */
    private static void textExpression() {
        ExpressionParser parser = new SpelExpressionParser();

        String[] lELs = {"'hello SpEL'", "1.028E+7", "0x12EF", "true", "null"};
        assert "hello SpEL".equals(parser.parseExpression(lELs[0]).getValue(String.class));
        assert new Double(10280000).equals(parser.parseExpression(lELs[1]).getValue(Double.class));
        assert new Integer(4847).equals(parser.parseExpression(lELs[2]).getValue(Integer.class));
        assert parser.parseExpression(lELs[3]).getValue(Boolean.class);
        assert parser.parseExpression(lELs[4]).getValue() == null;
    }

    /**
     * 访问对象属性
     */
    private static void objectProperty() {
        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(parser.parseExpression("'hello'.length()").getValue());
        System.out.println(parser.parseExpression("'hello'.empty").getValue());

        Date date = new Date();
        System.out.println(date);
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("date", date);
        //通过'#'获取上下文的变量
        System.out.println(parser.parseExpression("#date.time").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#date.Time").getValue(evaluationContext));//大小写都可以
    }

    /**
     * 访问数组
     */
    private static void array() {
        int[] ints = new int[]{1, 2, 3, 4, 5};
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("ints", ints);
        //通过'#'获取上下文的变量
        System.out.println(parser.parseExpression("#ints[0]").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints[1]").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints[2]").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints[3]").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints[4]").getValue(evaluationContext));
    }

    /**
     * 访问List
     */
    private static void list() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("ints", ints);
        //通过'#'获取上下文的变量
        System.out.println(parser.parseExpression("#ints.get(0)").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints.get(1)").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints.get(2)").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints.get(3)").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#ints.get(4)").getValue(evaluationContext));
    }

    /**
     * 访问Map
     */
    private static void map() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setVariable("map", map);
        //通过'#'获取上下文的变量
        System.out.println(parser.parseExpression("#map.get('1')").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#map['2']").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#map.get('2')").getValue(evaluationContext));
        System.out.println(parser.parseExpression("#map.get('3')").getValue(evaluationContext));
    }

    /**
     * 内置列表
     */
    private static void builtInList() {
        ExpressionParser parser = new SpelExpressionParser();
        //构建List<>
        List<Integer> integers = (List<Integer>) parser.parseExpression("{2,3}").getValue();
        System.out.println(Arrays.toString(integers.toArray()));
        //构建List<List<>>
        List<List<Integer>> lists = (List<List<Integer>>) parser.parseExpression("{{2,3},{4,5}}").getValue();
        System.out.println(Arrays.toString(lists.toArray()));
    }

    /**
     * 构建数组
     */
    private static void builtArray() {
        ExpressionParser parser = new SpelExpressionParser();
        //创建没有初始值的数组
        int[] ints1 = (int[]) parser.parseExpression("new int[2]").getValue();
        System.out.println(Arrays.toString(ints1));
        //创建带有初始值的数组
        int[] ints2 = (int[]) parser.parseExpression("new int[]{1,2}").getValue();
        System.out.println(Arrays.toString(ints2));
        //创建二维数组
        int[][] ints3 = (int[][]) parser.parseExpression("new int[2][2]").getValue();
        //int[][] ints3 = (int[][]) parser.parseExpression("new int[2][2]{{1,2},{3,4}}").getValue();//暂不支持多维数组初始化 Using an initializer to build a multi-dimensional array is not currently supported
        System.out.println(Arrays.toString(ints3));
    }

    /**
     * 方法调用
     */
    private static void methodInvoke() {
        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("'hello'.substring(1, 4)").getValue());
    }

    /**
     * 关系运算符
     */
    private static void relationOperator() {
        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("1 == 1").getValue(Boolean.class));
        System.out.println(parser.parseExpression("1 eq 1").getValue(Boolean.class));
        System.out.println(parser.parseExpression("1 > -1").getValue(Boolean.class));
        System.out.println(parser.parseExpression("1 gt -1").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'a' < 'b'").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'a' lt 'b'").getValue(Boolean.class));
        System.out.println(parser.parseExpression(" new Integer(123) instanceof T(Integer) ").getValue(Boolean.class));
        System.out.println(parser.parseExpression("'5.00' matches '^-?\\d+(\\.\\d{2})?$'").getValue(Boolean.class));
    }

    /**
     * 逻辑运算符
     */
    private static void logicOperator() {
        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("true and false").getValue(Boolean.class));
        System.out.println(parser.parseExpression("true or false").getValue(Boolean.class));
        System.out.println(parser.parseExpression("not false").getValue(Boolean.class));
    }

    /**
     * 算术运算符
     */
    private static void arithmeticOperator() {
        ExpressionParser parser = new SpelExpressionParser();
        System.out.println(parser.parseExpression("1 + 2").getValue(Double.class));
        System.out.println(parser.parseExpression("1 - 2").getValue(Double.class));
        System.out.println(parser.parseExpression("1 / 2").getValue(Double.class));
        System.out.println(parser.parseExpression("1 div 2").getValue(Double.class));
        System.out.println(parser.parseExpression("1 % 2").getValue(Double.class));
        System.out.println(parser.parseExpression("1 mod 2").getValue(Double.class));
    }

    /**
     * 赋值
     */
    private static void assign() {
        ExpressionParser parser = new SpelExpressionParser();
        Calendar instance = Calendar.getInstance();
        instance.set(2004, Calendar.FEBRUARY, 2);
        Date date = instance.getTime();
        System.out.println(date);
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("date", date);
        //赋值（注意赋值只是改变了ctx中的变量，并没有改变原来的date）
        parser.parseExpression("#date").setValue(ctx, new Date());
        //打印赋值后的值
        System.out.println(parser.parseExpression("#date").getValue(ctx));

        System.out.println(date);
    }

    /**
     * 类型
     */
    private static void type() {
        ExpressionParser parser = new SpelExpressionParser();
        Class dateClass = parser.parseExpression("T(java.util.Date)").getValue(Class.class);
        System.out.println(dateClass);
        System.out.println(parser.parseExpression("T(java.math.RoundingMode).CEILING < T(java.math.RoundingMode).FLOOR").getValue(Boolean.class));
    }

    /**
     * 构造器
     */
    private static void construct() {
        ExpressionParser parser = new SpelExpressionParser();
        Date date = parser.parseExpression("new java.util.Date()").getValue(Date.class);
        System.out.println(date);
    }

    /**
     * 变量
     */
    private static void variable() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 9);
        //EvaluationContext ctx = new StandardEvaluationContext();//未设置rootObject
        EvaluationContext ctx = new StandardEvaluationContext("123456");
        ctx.setVariable("list", list);
        List<Integer> vList = (List<Integer>) parser.parseExpression("#list").getValue(ctx);
        System.out.println(list.equals(vList));
        System.out.println(parser.parseExpression("length()").getValue(ctx));//只能调用rootObject变量的length()方法
    }

    /**
     * 三元操作符(包含Elvis运算符 '?:')
     */
    private static void ternaryOperator() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 9);
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("list", list);
        ctx.setVariable("name", "");
        //Java 三元运算符
        System.out.println(parser.parseExpression("#list.size()>5?'yes':'no'").getValue(ctx));
        // Elvis运算符
        System.out.println(parser.parseExpression("#name?:'nero'").getValue(ctx));
    }

    /**
     * 安全导航操作
     */
    private static void safeNavigationOperator() {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("name1", null);
        ctx.setVariable("name2", "nero");
        System.out.println(parser.parseExpression("#name1?.length()").getValue(ctx));
        System.out.println(parser.parseExpression("#name2?.length()").getValue(ctx));
    }

    /**
     * 集合选择
     */
    private static void collectionSelect() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 9);

        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("list", list);
        List<Integer> integerList = (List<Integer>) parser.parseExpression("#list.?[#this > 5]").getValue(ctx);
        System.out.println(integerList);
        // 获取符合条件的第一个元素
        System.out.println(parser.parseExpression("#list.^[#this > 5]").getValue(ctx));
        // 获取符合条件的最后一个元素
        System.out.println(parser.parseExpression("#list.$[#this > 5]").getValue(ctx));

        //map
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        ctx.setVariable("map", map);
        System.out.println(parser.parseExpression("#map.?[value > 1]").getValue(ctx));
        System.out.println(parser.parseExpression("#map.?[!key.equals('3')]").getValue(ctx));
    }

    /**
     * 集合投影
     */
    private static void collectionMap() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 9);

        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("list", list);
        List<Integer> integerList = (List<Integer>) parser.parseExpression("#list.![#this * 5]").getValue(ctx);
        System.out.println(integerList);
    }

    /**
     * 模板表达式
     */
    private static void templateExpr() {
        ExpressionParser parser = new SpelExpressionParser();
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 9);
        User user = new User(1, "nero", 18);
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("list", list);
        System.out.println(parser.parseExpression(
                "this is #{#list.get(0)} that is #{#list.get(1)}", new TemplateParserContext()).getValue(ctx));
        System.out.println(parser.parseExpression("his name is #{name} age is #{age}",
                new TemplateParserContext()).getValue(user));
        System.out.println(parser.parseExpression("systemProperties['os.name']").getValue());
    }

    /**
     * 访问字典类型Dictionary(Properties)
     */
    private static void accessDictionary() {
        ExpressionParser parser = new SpelExpressionParser();
        Properties properties = new Properties();
        properties.setProperty("name", "nero");
        EvaluationContext ctx = new StandardEvaluationContext();
        ctx.setVariable("properties", properties);
        System.out.println(parser.parseExpression("#properties['name']").getValue(ctx));
    }
}
