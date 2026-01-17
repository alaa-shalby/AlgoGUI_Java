import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AlgoGUI {

    JFrame frame;
    JTextField inputField;
    JLabel resultLabel;
    JComboBox<String> sortBox;
    JButton executeSortBtn; // زرار لتنفيذ السورت بعد اختيار النوع

    public AlgoGUI() {
        frame = new JFrame("Sorting & Searching Algorithms");
        frame.setSize(600, 300);
        frame.setLayout(null);// بتخليني احدد يدوي طريقة ترتيب العناصر
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// علشان اقدر اقفل الشكل من علامة الاكس ويوقف رن
        ImageIcon image=new ImageIcon("Algo.png");//Create ImageIcon
        frame.setIconImage(image.getImage());//Change the Icon of this
        frame.getContentPane().setBackground(Color.lightGray);
        // ===== Input Array =====
        JLabel inputLabel = new JLabel("Enter numbers (space separated):");
        inputLabel.setBounds(30, 30, 250, 25);// بحدد مكان النص اللي هكتبه
        frame.add(inputLabel);// ضيفته للفريم بتاعي

        inputField = new JTextField();// المكان اللي هيدخل فيه اليوزر العناصر
        inputField.setBounds(280, 30, 280, 25);
        frame.add(inputField);

        // ===== Buttons =====
        JButton sortBtn = new JButton("Sort");
        sortBtn.setBounds(150, 100, 100, 30);
        frame.add(sortBtn);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(350, 100, 100, 30);
        frame.add(searchBtn);

        // ===== Sort ComboBox =====
        String[] sortTypes = {"BubbleSort","SelectionSort","InsertionSort","MergeSort","QuickSort"};
        sortBox = new JComboBox<>(sortTypes); //
        sortBox.setBounds(230, 150, 150, 25);
        sortBox.setVisible(false);
        frame.add(sortBox);

        // ===== Execute Sort Button =====
        executeSortBtn = new JButton("Execute Sort");
        executeSortBtn.setBounds(400, 150, 130, 25);
        executeSortBtn.setVisible(false);
        frame.add(executeSortBtn);

        // ===== Result Label =====
        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(30, 200, 500, 25);
        frame.add(resultLabel);

        // ===== Sort Button Action =====
        sortBtn.addActionListener(e -> {
            sortBox.setVisible(true);
            executeSortBtn.setVisible(true);
            resultLabel.setText("Select sort type and click Execute Sort");
        });

        // ===== Execute Sort Action =====
        executeSortBtn.addActionListener(e -> {
            int[] arr = getNumbers();
            String selectedSort = (String) sortBox.getSelectedItem();

            switch (selectedSort) {
                case "BubbleSort":
                    arr = Main.BubbleSort(arr);
                    break;
                case "SelectionSort":
                    arr = Main.SelectionSort(arr);
                    break;
                case "InsertionSort":
                    arr = Main.InsertionSort(arr);
                    break;
                case "MergeSort":
                    Main.MergeSort(arr, 0, arr.length - 1);
                    break;
                case "QuickSort":
                    Main.QuickSort(arr, 0, arr.length - 1);
                    break;
            }

            resultLabel.setText("Sorted Array: " + Arrays.toString(arr));
        });

        // ===== Search Button Action =====
        searchBtn.addActionListener(e -> {
            sortBox.setVisible(false);
            executeSortBtn.setVisible(false);
            int[] arr = getNumbers();

            String response = JOptionPane.showInputDialog("Is the array sorted? (yes/no)");// هياخد هو الااري بتاعته سورتيد ولا لا

            int key = Integer.parseInt(JOptionPane.showInputDialog("Enter number to search:"));// البوكس اللي هياخد فيه الرقم اللي هيسرش عليه
            int index;

            if (response.equalsIgnoreCase("yes")) { // لو الاجابة ب يس هيستخدم الباينري غير كدا هيستخدم اللينر
                index = Main.BinarySearch(arr, key);
            } else {
                index = Main.LinearSearch(arr, key);
            }

            if (index != -1)
                resultLabel.setText("Number found at index: " + index);// لو الاندكس فضل بسالب 1 يبقى مش موجود لو اتغير هيبين انه موجود ويبعت الاندكس بتاعه
            else
                resultLabel.setText("Number not found");
        });

        frame.setVisible(true);
    }

    // ===== تحويل input إلى int array =====
    private int[] getNumbers() { // اى انبوت بستقبله بيبقى سترينج وانا اللي بحوله لأي داتا تايب عندي ف هحتاج احولهم ل انتجر
        String[] parts = inputField.getText().trim().split("\\s+"); // trim هتشيل اي مسافات في الاول او الاخر
        // جزء السبليت هيسم من عند كل مسافة وكل دا هيتخزن جوا الااري بتاع بارتس
        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
         //اللوب هدفها يمشي على كل رقم يحوله لانتجر
        return numbers;
    }

}