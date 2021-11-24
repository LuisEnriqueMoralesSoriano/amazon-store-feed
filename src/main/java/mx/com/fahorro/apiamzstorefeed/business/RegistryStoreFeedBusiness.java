package mx.com.fahorro.apiamzstorefeed.business;

import mx.com.fahorro.apiamzstorefeed.entity.BranchEntity;
import mx.com.fahorro.apiamzstorefeed.exception.ExceptionEmptyResultBD;
import mx.com.fahorro.apiamzstorefeed.model.dto.ResponseDto;
import mx.com.fahorro.apiamzstorefeed.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistryStoreFeedBusiness {

    @Autowired
    private BranchRepository branchRepository;

    public ResponseDto createStoreFeed() {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus("OK");
        responseDto.setMensaje("8285af73-5a7f-4521-90c5-cf5a7f7aed6d");
        return responseDto;
    }


    public BranchEntity findById(String id) throws ExceptionEmptyResultBD {
        List<BranchEntity> branchList = new ArrayList();
        BranchEntity result;

        branchList = branchRepository.findByFarmaId(id);

        if (branchList.size() != 0) {
            result = branchList.get(0);
        } else {
            throw new ExceptionEmptyResultBD("No se encontro registro para el id " + id);
        }

        return result;
    }
}
