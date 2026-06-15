package lk.ijse.OrderManagementSystem.service.impl;

import lk.ijse.OrderManagementSystem.dto.ItemDTO;
import lk.ijse.OrderManagementSystem.entity.Item;
import lk.ijse.OrderManagementSystem.repository.ItemRepository;
import lk.ijse.OrderManagementSystem.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveItem(ItemDTO item) {
        log.info("Execute Method saveItem");
        try {

            Item item1 = new Item();
            item1.setItemName(item.getItemName());
            item1.setItemPrice(item.getItemPrice());

            itemRepository.save(item1);

        } catch (Exception e) {
            log.error("Error in saveItem: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        log.info("Execute Method getAllItems");
        try {

            List<ItemDTO> itemDTOList = new ArrayList<>();
            List<Item> itemList = itemRepository.findAll();

            for (Item item : itemList) {
                ItemDTO itemDTO = new ItemDTO();
                itemDTO.setItemId(item.getItemId());
                itemDTO.setItemName(item.getItemName());
                itemDTO.setItemPrice(item.getItemPrice());

                itemDTOList.add(itemDTO);
            }
            return itemDTOList;

        } catch (Exception e) {
            log.error("Error in getAllItems: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ItemDTO getItemDetail(long id) {
        log.info("Execute Method getItemDetail");
        try {

            Optional<Item> itemOptional = itemRepository.findById(id);
            if (!itemOptional.isPresent()) {
                throw new RuntimeException("Item not found");
            }
            Item item = itemOptional.get();
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemId(item.getItemId());
            itemDTO.setItemName(item.getItemName());
            itemDTO.setItemPrice(item.getItemPrice());

            return itemDTO;

        } catch (Exception e) {
            log.error("Error in getItemDetail: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        log.info("Execute Method updateItem");
        try {

            Optional<Item> itemOptional = itemRepository.findById(itemDTO.getItemId());
            if (!itemOptional.isPresent()) {
                throw new RuntimeException("Item not found");
            }
            Item item = itemOptional.get();
            item.setItemName(itemDTO.getItemName());
            item.setItemPrice(item.getItemPrice());

            itemRepository.save(item);

        }  catch (Exception e) {
            log.error("Error in updateItem: {}", e.getMessage());
            throw e;
        }
    }
}