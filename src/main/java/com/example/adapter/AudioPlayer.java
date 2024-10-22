package com.example.adapter;

// Client class
// 어댑터 패턴을 사용하는 객체로, 기존의 기능과 새로 추가된 기능을 통합하여 구현한 인터페이스를 호출한다.
public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter; // 어댑터 객체를 참조

    // 클라이언트가 기대하는 기능 -> play()
    // play 라는 공통 인터페이스 하나로 통일성을 해치지않고 기존 코드와 새 코드를 통합하여 사용
    @Override
    public void play(String audioType, String fileName) {
        // 기본적으로 mp3는 자체적으로 지원하여 그냥 재생 (기존에 구현돼있던 기능/기존 코드)
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }

        // mp4나 vlc 같은 기존과 다른 형식은 어댑터를 통해 클라이언트가 원하는 형태로 통일된 방식으로(play) 재생 (새로 추가된 기능)
        else if (audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. ");
        }
    }
}
