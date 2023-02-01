package com.example.demo.Service;
import com.example.demo.Model.Category;
import com.example.demo.Repositry.CateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CateImplement implements CateInterface {

    @Autowired
    private CateRepo cateRepo;

    @Override
    public Category createCategory(Category category) {
        return this.cateRepo.save(category);

    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> catObj = this.cateRepo.findById(category.getCategoryId());
        if(catObj.isPresent()){
            Category updatedCat = catObj.get();
            updatedCat.setName(category.getName());
            return this.cateRepo.save(updatedCat);
        } else {
            throw new RuntimeException("Cat does not exist");
        }
    }

    @Override
    public List<Category> getAllCategory() {
        return this.cateRepo.findAll();
    }

    @Override
    public Category getCategoryById(long id) {
        Optional<Category> cate = this.cateRepo.findById(id);
        if(cate.isPresent()){
            return cate.get();
        } else{
            throw new RuntimeException("Book does not exist");
        }
    }

    @Override
    public void deleteCategory(long id) {
        Optional<Category> cate = this.cateRepo.findById(id);
        if (cate.isPresent()) {
            this.cateRepo.deleteById(id);
        } else {
            throw new RuntimeException("Book does not exist");
        }
    }
}
