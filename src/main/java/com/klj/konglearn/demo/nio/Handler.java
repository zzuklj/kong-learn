package com.klj.konglearn.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

final class Handler implements Runnable {

    final SocketChannel socketChannel;
    final SelectionKey selectionKey;

    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    static final int READING = 0, SENDING = 1;
    int state = READING;

    Handler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        //先设置为读操作
        this.selectionKey = this.socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        try {

            if(state == READING){
                read();
            } else if(state == SENDING){
                send();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send() throws IOException {
        socketChannel.write(output);
        if(outputIsComplete()){
            selectionKey.cancel();
        }
    }

    private boolean outputIsComplete() {
        return true;
    }

    private void read() throws IOException {
        socketChannel.read(input);
        if(inputIsComplete()){
            process();
            state = SENDING;
            selectionKey.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private void process() {
    }

    private boolean inputIsComplete() {
        return true;
    }
}
