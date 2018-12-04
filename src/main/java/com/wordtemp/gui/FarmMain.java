package com.wordtemp.gui;

import com.wordtemp.util.GetWord;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FarmMain extends JFrame {
    public Button button = new Button("选择word模板");
    public Label label_temp = new Label();
    public Label label_out = new Label();
    public FarmMain(String title){
        this.setTitle(title);
        this.setLayout(null);
        this.setResizable(false);
        initButton();
        initChoose();
        this.setBounds(400,200,600,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    // 选择学科，生成题库数量
    private void initChoose() {
        JCheckBox jCheckBox = new JCheckBox();

    }

    public void initButton(){
        final String pleaseChoose = "请选择word模板" ;
        // path label
        label_temp.setText(pleaseChoose);
        label_temp.setBounds(20,250,440,50);
        label_temp.setFont(new Font("宋体", Font.PLAIN, 16));
        this.add(label_temp);
        // out lable
        label_out.setText("生成word名称:");
        label_out.setBounds(20,300,120,50);
        label_out.setFont(new Font("宋体", Font.PLAIN, 16));
        this.add(label_out);
        // out file name
        final JTextField jTextField = new JTextField();
        jTextField.setFont(new Font("宋体", Font.PLAIN, 16));
        jTextField.setBounds(150,310,200,30);
        this.add(jTextField);
        // ret message
        final JLabel ret = new JLabel();
        ret.setFont(new Font("宋体", Font.PLAIN, 16));
        ret.setBounds(370,310,80,30);
        this.add(ret);
        // get word
        Button getword = new Button("生成");
        getword.setBounds(460,300,100,40);
        getword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ret.setText("");
                String tempName = label_temp.getText() ;
                String outFileName = jTextField.getText() ;
                if ((tempName.equals(pleaseChoose)||outFileName==null)){
                    JFrame frame = new JFrame();
                    frame.setTitle("提示");
                    Label error = new Label("请选择模板或输入文件名");
                    frame.add(error);
                    frame.setBounds(300,300,250,100);
                    frame.setVisible(true);
                }else {
                    GetWord getWord = new GetWord();
                    try {
                        getWord.exportSimpleWord(tempName,outFileName);
                        ret.setText("OK");
                    } catch (Exception e1) {
                        System.out.println(e1);
                        JFrame frame2 = new JFrame();
                        frame2.setTitle("提示");
                        Label error2 = new Label(e1.toString());
                        frame2.add(error2);
                        frame2.setBounds(300,300,250,100);
                        frame2.setVisible(true);
                    }
                }
            }
        });
        this.add(getword);
        // choose file
        button.setBounds(460,250,100,40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser("src\\main\\java\\ftl\\") ;
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jFileChooser.showOpenDialog(null);
                File f = jFileChooser.getSelectedFile();
                if(f != null){
                    System.out.println(f.getPath());
                    String filePath[] = f.getPath().split("\\\\");
                    label_temp.setText(filePath[filePath.length-1]);
                    System.out.println(label_temp.getText());
                }
            }
        });
        this.add(button);
    }
    public static void main(String[] args) {
        new FarmMain("GetWord");        //创建窗口
    }
}