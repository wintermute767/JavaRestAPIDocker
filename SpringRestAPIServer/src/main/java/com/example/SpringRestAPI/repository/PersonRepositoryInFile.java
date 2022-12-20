package com.example.SpringRestAPI.repository;

import com.example.SpringRestAPI.model.PersonV1;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@ToString
@Repository
@Profile("dev")
public class PersonRepositoryInFile<T extends PersonV1> implements ObjectRepository<T, Integer> {

    private List<T> repository;

    private FileSystemResource fileForData;

    @Autowired
    public PersonRepositoryInFile(@Value("${repository.file}") String repositoryFile) {
        this.fileForData = new FileSystemResource(repositoryFile);
        this.repository = new ArrayList<>();
        if (this.fileForData != null) {
            try (ObjectInputStream ois = new ObjectInputStream(this.fileForData.getInputStream())) {
                ArrayList<T> fileData = new ArrayList<T>((ArrayList<T>) ois.readObject());
                this.repository.addAll(fileData);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void save(T person) {
        repository.add(person);
        this.writeToFile();
    }

    public void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(this.fileForData.getOutputStream())) {
            oos.writeObject(this.repository);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public T getById(Integer ID) {
        System.out.println(this.repository);
        if (ID < repository.size()) {
            return repository.get(ID);
        }
        return null;
    }

    @Override
    public void deleteById(Integer ID) {
        this.repository.remove(ID);
    }

    @Override
    public void updateById(Integer ID, T person) {
        this.repository.set(ID, person);
    }


}
