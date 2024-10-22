package com.example.adapter;

// Adapter class
// 타겟 인터페이스를 구현하며, 변환 대상이 되는 어댑티를 참조하고 있다.
// 타겟의 인터페이스를 어댑티의 인터페이스로 변환하는 역할을 수행
// 클라이언트는 Target 인터페이스를 기대하고 있기 때문에, Adapter가 중간에서 변환 역할을 함.
public class MediaAdapter implements MediaPlayer{ // 기존 코드의 기능
    private VlcPlayer vlcPlayer; // 새로 추가되는 기능
    private Mp4Player mp4Player;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mp4Player = new Mp4Player();
        }
    }

    // 어댑터를 통해 타겟의 인터페이스가 호출되는 것처럼 보이지만 실제로 기능 내부에서는 어댑터가 감싼 새로운 객체의 메서드를 호출한다.
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName); // Adaptee의 메서드를 호출하지만, Target 인터페이스의 형태로 변환하여 반환
        } else if (audioType.equalsIgnoreCase("mp4")) {
            mp4Player.playMp4(fileName);
        }
    }
}
