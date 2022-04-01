package com.klj.konglearn.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Runnable {

    final Selector selector;
    final ServerSocketChannel serverSocketChannel;

    //设置
    public Reactor(int port) throws IOException {
        this.selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        selectionKey.attach(new Acceptor());
    }

    @Override
    public void run() {//循环分发
        try {
            while (!Thread.interrupted()) {
                selector.select();
                Set<SelectionKey> selected = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selected.iterator();
                while(iterator.hasNext()){
                    dispatch(iterator.next());
                }
                selected.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void dispatch(SelectionKey k) {
        Runnable r = (Runnable)(k.attachment());
        if(r != null) r.run();
    }

    private class Acceptor implements Runnable{
        @Override
        public void run() {
            try {
                SocketChannel accept = serverSocketChannel.accept();
                //if(accept != null) new Handler(selector, accept);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
