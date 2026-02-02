# P.181 Q.14 [표 편집]
출처 : 프로그래머스
Level : 3

## 풀이 날짜
2026.02.01 X

## 문제 풀이
```java
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ublic int[] solution(String[] genres, int[] plays) {

        // 1. 장르별 총 재생 수
        Map<String, Integer> genreTotal = new HashMap<>();

        // 2. 장르별 노래 목록
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int p = plays[i];

            if (!genreSongs.containsKey(g)) {
                genreSongs.put(g, new ArrayList<>());
            }
            genreSongs.get(g).add(new Song(i, p));
            genreTotal.put(g, genreTotal.getOrDefault(g, 0) + p);
        }

        // 3. 장르를 총 재생 수 기준으로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        // 4. 결과 뽑기
        List<Integer> result = new ArrayList<>();

        for (String g : sortedGenres) {
            List<Song> songs = genreSongs.get(g);

            // 장르 내 노래 정렬
            songs.sort((a, b) -> {
                if (b.play != a.play) return b.play - a.play;   // 재생수 내림차순
                return a.id - b.id;                             // 고유번호 오름차순
            });

            result.add(songs.get(0).id);
            if (songs.size() > 1) {
                result.add(songs.get(1).id);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    static class Song {
        int id; // 인덱스
        int play;

        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
}
```

## 접근 방식

## 개선사항