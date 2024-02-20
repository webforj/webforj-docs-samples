package addondemos.tabledemos;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.dwcj.data.repository.CollectionRepository;
import org.dwcj.data.repository.Repository;
import org.dwcj.utilities.Assets;

public final class Service {

  private Service() {}

  public static Repository<MusicRecord> getMusicRecords() {
    List<MusicRecord> data =
        new Gson().fromJson(Assets.contentOf(Assets.resolveContextUrl("context://data/CDStore.json")),
            new TypeToken<List<MusicRecord>>() {});

    return new CollectionRepository<>(data);
  }
}
